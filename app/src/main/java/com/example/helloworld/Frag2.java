package com.example.helloworld;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag2_layout, container, false);

        Button Btn1 = (Button) view.findViewById(R.id.Btn1);
        Button Btn2 = (Button) view.findViewById(R.id.Btn2);
        Button Btn3 = (Button) view.findViewById(R.id.Btn3);
        Button Btn4 = (Button) view.findViewById(R.id.Btn4);
        Button Btn5 = (Button) view.findViewById(R.id.Btn5);
        Button Btn6 = (Button) view.findViewById(R.id.Btn6);

        Btn1.setOnClickListener(v -> {
            Toast.makeText(getActivity(), "You Liked Crazy", Toast.LENGTH_SHORT).show();
        });

        Btn2.setOnClickListener(v -> {
            Toast.makeText(getActivity(), "You Liked Shy", Toast.LENGTH_SHORT).show();
        });

        Btn3.setOnClickListener(v -> {
            Toast.makeText(getActivity(), "You Liked Happy", Toast.LENGTH_SHORT).show();
        });

        Btn4.setOnClickListener(v -> {
            Toast.makeText(getActivity(), "You Liked Eye Roll", Toast.LENGTH_SHORT).show();
        });

        Btn5.setOnClickListener(v -> {
            Toast.makeText(getActivity(), "You Liked Annoyed", Toast.LENGTH_SHORT).show();
        });

        Btn6.setOnClickListener(v -> {
            Toast.makeText(getActivity(), "You Liked Cry", Toast.LENGTH_SHORT).show();
        });

        return view;

    }
}
