package com.example.basicloader;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QueryUtils {


    public static  String getJSONData(String url){

        String s = null;
        try {

            JSONObject jobject = new JSONObject(url);


            JSONArray jarray = jobject.getJSONArray("features");

            for(int i=0;i<jarray.length();i++){
                JSONObject current = jarray.getJSONObject(i);
                JSONObject properties = current.getJSONObject("properties");

                double magnitude = properties.getDouble("mag");

                String city = properties.getString("place");

                long date = properties.getLong("time");


                s = s + (magnitude+" "+city+"\n");

                Log.e("QueryUtils",magnitude+" "+city);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return s;
    }
}
