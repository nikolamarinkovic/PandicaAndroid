package com.example.pandica_anroid;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pandica_anroid.Models.User;

import org.w3c.dom.Text;

public class LoginFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        //setting title
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Pandica");

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Button buttonLogin = (Button) view.findViewById(R.id.buttonLoginLogin);


        buttonLogin.setOnClickListener((view2) -> {
            TextView errorTextView = (TextView) view.findViewById(R.id.errorTextViewLogin);

            EditText usernameEditText = (EditText) view.findViewById(R.id.usernameEditTextLogin);
            EditText passwordEditText = (EditText) view.findViewById(R.id.passwordEditTextLogin);


            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if(username.equals("") || password.equals("")){
                errorTextView.setText("Popunite sva polja.");
                return;
            }

            if(User.loginCredentialsGood(username, password) == true){
                //todo: dodati prelazak na drugu stranu
                errorTextView.setText("Uspeh");
                return;
            }
            else{
                errorTextView.setText("Pogresni podaci.");
                return;
            }
        });


    }
}