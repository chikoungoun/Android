package com.example.cuturehttp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class QueryUtils {

    private static final String JSON_FILE ="[{\"noms\":\"ALICE AU PAYS DES MERVEILLES \",\"date\":\"8 juin 2019\",\"heure\":\"9:00\",\"image\":\"http:\\/\\/tnm5.ma\\/wp-content\\/uploads\\/2019\\/06\\/8juin.jpg\"},"+
            "{\"noms\":\"Artemesia Club : spectacle de Danse \",\"date\":\"9 juin 2019\",\"heure\":\"8:00\",\"image\":\"http:\\/\\/tnm5.ma\\/wp-content\\/uploads\\/2019\\/03\\/Scan.jpg\"},"+
            "{\"noms\":\"spectacle de danse moderne \",\"date\":\"10 juin 2019\",\"heure\":\"18:30\",\"image\":\"http:\\/\\/tnm5.ma\\/wp-content\\/uploads\\/2019\\/03\\/10juin.jpg\"},"+
            "{\"noms\":\"spectacle de danse classique \",\"date\":\"11 juin 2019\",\"heure\":\"19:00\",\"image\":\"http:\\/\\/tnm5.ma\\/wp-content\\/uploads\\/2019\\/03\\/11juin.jpg\"}]";


    //privée car on a pas besoin de créer d'objet QueryUtils
    private QueryUtils() {
    }

    //Extraire un array d'objet depuis le JSON
    public static ArrayList<Spectacle> extractSpectacles(){

        ArrayList<Spectacle> spectacles = new ArrayList<Spectacle>();

        try{
            //JSONObject jobject = new JSONObject(JSON_FILE);

            JSONArray jsonArray = new JSONArray(JSON_FILE);

            for(int i=0;i<jsonArray.length();i++){

                JSONObject jObject = jsonArray.getJSONObject(i);

                String nom = jObject.getString("noms");
                String date = jObject.getString("date");
                String heure = jObject.getString("heure");

                Spectacle spectacle = new Spectacle(nom,date,heure);

                spectacles.add(spectacle);
            }

        }catch (JSONException e){
            Log.e("QueryUtils","Problems with parsing the JSON file",e);

        }

        return spectacles;
    }
}
