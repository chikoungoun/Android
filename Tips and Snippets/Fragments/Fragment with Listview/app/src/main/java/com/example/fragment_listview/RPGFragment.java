package com.example.fragment_listview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RPGFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RPGFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public RPGFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RPGFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RPGFragment newInstance(String param1, String param2) {
        RPGFragment fragment = new RPGFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.game_list, container, false);

        ArrayList<Game> games = new ArrayList<Game>();

        games.add(new Game("Cloud","Strife"));
        games.add(new Game("Geralt","The witcher"));
        games.add(new Game("Ivan","Le vent"));

        GameAdapter adapter = new GameAdapter(getActivity(),games);

        ListView listView = (ListView)view.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return  view;
    }

}
