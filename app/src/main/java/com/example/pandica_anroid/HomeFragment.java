package com.example.pandica_anroid;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //setting title
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Pandica");

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Button loginButton = view.findViewById(R.id.buttonGoToLogin);
        Button registerButton = view.findViewById(R.id.buttonGoToRegister);


        loginButton.setOnClickListener( (view2) -> {
            Navigation.findNavController(view2).navigate(R.id.action_homeFragment_to_loginFragment);
        });

        registerButton.setOnClickListener( (view2) -> {
            Navigation.findNavController(view2).navigate(R.id.action_homeFragment_to_registerFragment);
        });


    }
}