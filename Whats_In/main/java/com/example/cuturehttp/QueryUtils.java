package com.example.cuturehttp;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class QueryUtils {

    private static final String JSON_FILE ="[{\"noms\":\"ALICE AU PAYS DES MERVEILLES \",\"date\":\"8 juin 2019\",\"heure\":\"9:00\",\"image\":\"http:\\/\\/tnm5.ma\\/wp-content\\/uploads\\/2019\\/06\\/8juin.jpg\"},"+
            "{\"noms\":\"Artemesia Club : spectacle de Danse \",\"date\":\"9 juin 2019\",\"heure\":\"8:00\",\"image\":\"http:\\/\\/tnm5.ma\\/wp-content\\/uploads\\/2019\\/03\\/Scan.jpg\"},"+
            "{\"noms\":\"spectacle de danse moderne \",\"date\":\"10 juin 2019\",\"heure\":\"18:30\",\"image\":\"http:\\/\\/tnm5.ma\\/wp-content\\/uploads\\/2019\\/03\\/10juin.jpg\"},"+
            "{\"noms\":\"spectacle de danse classique \",\"date\":\"11 juin 2019\",\"heure\":\"19:00\",\"image\":\"http:\\/\\/tnm5.ma\\/wp-content\\/uploads\\/2019\\/03\\/11juin.jpg\"}]";


    //privée car on a pas besoin de créer d'objet QueryUtils
    private QueryUtils() {
    }

    // Créer et vérifier le lien URL
    private static URL createURL(String stringUrl){
        URL url = null;

        try{
            url = new URL(stringUrl);
        }catch (MalformedURLException e){
            Log.e("QueryUtils","Problem building the URL",e);
        }

        return url;
    }

    // Effectuer la requête HTTP pour récupérer les données
    private static String makeHttpRequest(URL url) throws IOException{

        String jsonResponse = "";

        // Si l'URL est null
        if(url == null){
            return  jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try{
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Si le retour URL fonctionne bien (code 200), parsing de la réponse
            if(urlConnection.getResponseCode() == 200){
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            }else{
                Log.e("QueryUtils","Error Response code : "+urlConnection.getResponseCode());
            }
        }catch (IOException e){
            Log.e("QueryUtils","Problème pour récupérer le fichier JSON",e);
        }finally {
            if(urlConnection != null){
                urlConnection.disconnect();
            }

            if(inputStream != null){
                // fermer le inputstream peut générer une IOException, c'est pour quoi on la "jette"
                inputStream.close();
            }
        }

        return jsonResponse;
    }

    // Convertir le InputStream en String contenant la réponse JSON
    private static String readFromStream(InputStream inputStream) throws IOException{

        StringBuilder output = new StringBuilder();
        if(inputStream != null){
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null){
                output.append(line);
                line = reader.readLine();
            }
        }

        return output.toString();
    }

    //Extraire dans un array d'objet à partir du parsing du JSON
    public static ArrayList<Spectacle> extractFromJSON(String specJSON){

        //si le texte JSON est null
        if(TextUtils.isEmpty(specJSON)){
            return null;
        }

        ArrayList<Spectacle> spectacles = new ArrayList<Spectacle>();

        try{


            JSONArray jsonArray = new JSONArray(specJSON);

            for(int i=0;i<jsonArray.length();i++){

                JSONObject jObject = jsonArray.getJSONObject(i);

                String nom = jObject.getString("noms");
                String date = jObject.getString("date");
                String heure = jObject.getString("heure");
                String image = jObject.getString("image");
                String webLien = jObject.getString("lien");
                String lieu = jObject.getString("lieu");

                Spectacle spectacle = new Spectacle(nom,date,heure,image,lieu,webLien);

                spectacles.add(spectacle);
            }

        }catch (JSONException e){
            Log.e("QueryUtils","Problems with parsing the JSON file",e);

        }

        return spectacles;
    }

    // Fonction regroupement toutes les fonctionnalités
    public static List<Spectacle> fetchSpectacleData(String requestUrl){

        // créer l'objet URL
        URL url = createURL(requestUrl);

        // Effectuer requête Http
        String jsonResponse = null;
        try{
            jsonResponse = makeHttpRequest(url);
        }catch (IOException e){
            Log.e("fetchSpectacleData","Problème de requête HTTP",e);
        }

        List<Spectacle> spectacles = extractFromJSON(jsonResponse);

        return spectacles;
    }
}
