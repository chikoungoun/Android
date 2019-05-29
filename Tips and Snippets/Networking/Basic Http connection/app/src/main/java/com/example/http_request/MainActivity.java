package com.example.http_request;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyAsyncTask task = new MyAsyncTask();
        task.execute("https://www.google.com");



    }


    private class MyAsyncTask extends AsyncTask<String,Void,Object>{

        @Override
        protected Object doInBackground(String... urls) {

            // 1. Declare URL connection
            URL url = null;
            try {
                url = new URL(urls[0]);
            }catch (MalformedURLException e){
                Log.e("Exception","Problem Building the URL ",e);
            }

            HttpURLConnection conn = null;

            try{
                conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000);
                conn.setConnectTimeout(15000);
                conn.setRequestMethod("GET");
                conn.connect();

                if(conn.getResponseCode() == 200){
                    Log.e("Connexion","REUSSI");
                }else{
                    Log.e("Connexion","Error response code"+conn.getResponseCode());
                }

            }catch (IOException e){
                Log.e("Exception","Problem Building the URL ",e);
            }finally {
                if(conn != null){
                    conn.disconnect();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
        }
    }
}
