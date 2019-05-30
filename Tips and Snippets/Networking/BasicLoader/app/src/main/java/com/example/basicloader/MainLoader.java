package com.example.basicloader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.content.AsyncTaskLoader;
import android.util.Log;

public class MainLoader extends AsyncTaskLoader<String> {

    private String url;

    public MainLoader(Context context, String u) {
        super(context);
        url = u;
    }




    @Nullable
    @Override
    public String loadInBackground() {

        String result = QueryUtils.getJSONData(url);

        Log.e("QueryUtils",result);
        return result;
    }


    @Override
    protected void onStartLoading() {
        forceLoad();
    }


}
