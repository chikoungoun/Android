package com.example.myviewpager;


import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {

    private static final String KEY_POSITION ="position";
    private static final String KEY_COLOR = "color";


    public PageFragment() {
        // Required empty public constructor
    }

    //Creating a new Instance of PageFRAGMENT
    public static PageFragment newInstance(int position, int color){
        PageFragment frag = new PageFragment();

        Bundle args = new Bundle();
        args.putInt(KEY_POSITION,position);
        args.putInt(KEY_COLOR,color);
        frag.setArguments(args);

        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Getting the layout
        View result = inflater.inflate(R.layout.fragment_page,container,false);

        // getting the views
        LinearLayout rootView = (LinearLayout)result.findViewById(R.id.fragment_page_rootview);
        TextView textView = (TextView)result.findViewById(R.id.fragment_page_title);


        //getting data from bundle
        int position = getArguments().getInt(KEY_POSITION,-1);
        int color = getArguments().getInt(KEY_COLOR,-1);

        // updating the views
        rootView.setBackgroundColor(color);
        textView.setText("Page n° : "+position);

        Log.e(getClass().getSimpleName(),"onCreateView called for fragment number "+position);

        // Inflate the layout for this fragment
        return result;
    }

}
