package com.example.cuturehttp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SpectacleAdapter adapter;

    public static final String SPEC_JSON="https://raw.githubusercontent.com/chikoungoun/Android/master/Whats_In/main/tnm5_records";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.list);

        adapter = new SpectacleAdapter(this,new ArrayList<Spectacle>());

        listView.setAdapter(adapter);

        SpectacleAsyncTask task = new SpectacleAsyncTask();
        task.execute(SPEC_JSON);

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
