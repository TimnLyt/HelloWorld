package com.example.helloworld;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag1_layout, container, false);

        TextView text_input_name = (TextView) view.findViewById(R.id.text_name);
        TextView text_input_occupation = (TextView) view.findViewById(R.id.text_occupation);
        TextView text_input_description = (TextView) view.findViewById(R.id.text_description);
        TextView text_input_username = (TextView) view.findViewById(R.id.text_username);
        TextView birthdayText = (TextView) view.findViewById(R.id.text_age);


        String name = getActivity().getIntent().getStringExtra("keyname");
        String occupation = getActivity().getIntent().getStringExtra("keyoccupation");
        String description = getActivity().getIntent().getStringExtra("keydescription");
        String username = getActivity().getIntent().getStringExtra("keyusername");
        String age = getActivity().getIntent().getStringExtra("keyage");

        text_input_name.setText(name);
        text_input_occupation.setText(occupation);
        text_input_description.setText(description);
        text_input_username.setText(username);
        birthdayText.setText(age);

        Button goBack = (Button) view.findViewById(R.id.back_button);
        goBack.setOnClickListener(v -> getActivity().finish());

        return view;
    }
}
