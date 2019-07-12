package com.example.myfragments.Controllers.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myfragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public interface OnButtonClickedListener{
        public void onButtonClicked(View v);
    }

    private OnButtonClickedListener mCallBack;


    public MainFragment() {
        // Required empty public constructor
    }

    //Setting a listener on the button
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result = inflater.inflate(R.layout.fragment_main,container,false);

        // Setting the onClick Listener
        result.findViewById(R.id.fragment_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mCallBack.onButtonClicked(v);

            }
        });


        return result;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.createCallBackToParentActivity();
    }

    //Link the fragment to the activity
    private void createCallBackToParentActivity(){

        try{

            mCallBack = (OnButtonClickedListener)getActivity();

        }catch (ClassCastException e){
            throw new ClassCastException(e.toString()+ " must implement OnButtonClickedListener");
        }

    }

}
