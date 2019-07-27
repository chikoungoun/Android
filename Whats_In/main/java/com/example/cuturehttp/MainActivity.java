package com.example.cuturehttp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SpectacleAdapter adapter;

    public static final String SPEC_JSON="https://raw.githubusercontent.com/chikoungoun/Scraping/master/Maroc%20Culture/TNM5/tnm5_records";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.list);

        adapter = new SpectacleAdapter(this,new ArrayList<Spectacle>());

        listView.setAdapter(adapter);

        SpectacleAsyncTask task = new SpectacleAsyncTask();
        task.execute(SPEC_JSON);

        //Item Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Envoyer les infos de l'évènement vers une autre activity
                // pour l'afficher dans detail_page.xml
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("nom",adapter.getItem(position).getNom());
                intent.putExtra("date",adapter.getItem(position).getDate());
                intent.putExtra("heure",adapter.getItem(position).getHeure());
                intent.putExtra("webLien",adapter.getItem(position).getWebLien());
                intent.putExtra("lieu",adapter.getItem(position).getLieu());
                startActivity(intent);
            }
        });

    }

    // Il n'est pas possible d'effectuer des opérations networking sur le main Thread, de peur
    // de faire grandement ralentir le système. On utilise un thread parallèle

    private class SpectacleAsyncTask extends AsyncTask<String,Void, List<Spectacle>> {


        @Override
        protected List<Spectacle> doInBackground(String... urls) {

            if(urls.length < 1 || urls[0] == null){
                return null;
            }

            //Extraire les données du json
            List result = QueryUtils.fetchSpectacleData(urls[0]);

            return result;
        }



        @Override
        protected void onPostExecute(List<Spectacle> data) {

            // Nettoyer l'adapter des données précédentes
            adapter.clear();


            if(data != null && !data.isEmpty()){
                adapter.addAll(data);
            }
        }
    }
}
