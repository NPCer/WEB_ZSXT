package com.example.zxy.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.zxy.Activity.sendAdviceActivity;
import com.example.zxy.R;

public class MyFragment1 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);


        ImageView publish = (ImageView) view.findViewById(R.id.add);
        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), sendAdviceActivity.class);
                getActivity().startActivity(intent);

            }
        });

        return view;


     
    }


}
