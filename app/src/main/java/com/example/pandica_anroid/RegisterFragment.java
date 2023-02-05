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
import android.widget.Toast;

import com.example.pandica_anroid.Models.User;

public class RegisterFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        //setting title
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Pandica");

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button registerButton = (Button) view.findViewById(R.id.registerButtonRegister);




        registerButton.setOnClickListener((view2) -> {
            TextView errorTextView = (TextView) view.findViewById(R.id.errorTextViewRegister);

            EditText usernameEditText = (EditText) view.findViewById(R.id.usernameEditTextRegister);
            EditText passwordEditText = (EditText) view.findViewById(R.id.passwordEditTextRegister);
            EditText confirmedPasswordEditText = (EditText) view.findViewById(R.id.confirmedPasswordEditTextRegister);
            EditText firstNameEditText = (EditText) view.findViewById(R.id.firstNameEditTextRegister);
            EditText lastNameEditText = (EditText) view.findViewById(R.id.lastNameEditTextRegister);
            EditText phoneNumberEditText = (EditText) view.findViewById(R.id.phoneNumberEditTextRegister);
            EditText addressEditText = (EditText) view.findViewById(R.id.addressEditTextRegister);


            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            String confirmedPassword = confirmedPasswordEditText.getText().toString();
            String firstName = firstNameEditText.getText().toString();
            String lastName = lastNameEditText.getText().toString();
            String phoneNumber = phoneNumberEditText.getText().toString();
            String address = addressEditText.getText().toString();

            String resp = User.registerNewUser(username,password,confirmedPassword, "user", firstName, lastName, phoneNumber, address);

            if(resp.equals("OK")){
                Toast.makeText(getContext(),"Uspesna registracija.",Toast.LENGTH_LONG).show();
                Navigation.findNavController(view2).navigate(R.id.action_registerFragment_to_loginFragment);
                return;
            }
            else{
                errorTextView.setText(resp);
                return;
            }
        });

    }
}