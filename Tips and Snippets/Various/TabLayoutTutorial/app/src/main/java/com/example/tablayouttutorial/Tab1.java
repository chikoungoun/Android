package com.example.tablayouttutorial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Tab1  extends Fragment {
    private static final String HI = "https://uniqueandrocode.000webhostapp.com/hiren/androidtutorial/imgslider.php";
    private List<List_Data> list_data;
    private RecyclerView rv;
    private MyAdapter adapter;
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tab1,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv=(RecyclerView)view.findViewById(R.id.recyclerview);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        list_data=new ArrayList<>();

        getImageData();
    }

    private void getImageData() {
        request=new JsonArrayRequest(HI, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject=null;
                for (int i=0; i<response.length(); i++){
                    try {
                        JSONObject ob=response.getJSONObject(i);
                        List_Data listData =new List_Data(ob.getString("imageurl"));
                        list_data.add(listData);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                setupData(list_data);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue= Volley.newRequestQueue(getContext());
        requestQueue.add(request);
    }

    private void setupData(List<List_Data> list_data) {

        adapter=new MyAdapter(list_data,getContext());
        rv.setAdapter(adapter);
    }
}
