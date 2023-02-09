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


public class ChangeUserDetailsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_change_user_details, container, false);

        //setting title
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Pandica");

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button changeDataButton = view.findViewById(R.id.changeUserDetailsButtonChangeUserDetails);
        User currentUser = User.currentUser;

        EditText usernameEdit = view.findViewById(R.id.usernameEditTextChangeUserDetails);
        EditText firstNameEdit = view.findViewById(R.id.firstNameEditTextChangeUserDetails);
        EditText lastNameEdit = view.findViewById(R.id.lastNameEditTextChangeUserDetails);
        EditText phoneNumberEdit = view.findViewById(R.id.phoneNumberEditTextChangeUserDetails);
        EditText addressEdit = view.findViewById(R.id.addressEditTextChangeUserDetails);

        usernameEdit.setText(currentUser.getUsername());
        firstNameEdit.setText(currentUser.getFirstName());
        lastNameEdit.setText(currentUser.getLastName());
        phoneNumberEdit.setText(currentUser.getPhoneNumber());
        addressEdit.setText(currentUser.getAddress());

        changeDataButton.setOnClickListener((view2) -> {
            EditText usernameEdit2 = view.findViewById(R.id.usernameEditTextChangeUserDetails);
            EditText firstNameEdit2 = view.findViewById(R.id.firstNameEditTextChangeUserDetails);
            EditText lastNameEdit2 = view.findViewById(R.id.lastNameEditTextChangeUserDetails);
            EditText phoneNumberEdit2 = view.findViewById(R.id.phoneNumberEditTextChangeUserDetails);
            EditText addressEdit2 = view.findViewById(R.id.addressEditTextChangeUserDetails);

            EditText oldPasswordEdit = view.findViewById(R.id.oldPasswordEditTextChangeUserDetails);
            EditText newPasswordEdit = view.findViewById(R.id.newPasswordEditTextChangeUserDetails);
            EditText confirmedNewPassword = view.findViewById(R.id.newPasswordConfirmedEditTextChangeUserDetails);


            String newUsername = usernameEdit2.getText().toString();
            if(newUsername.length() == 0) {
                Toast.makeText(getContext(), "Korisnicko ime prazno.", Toast.LENGTH_LONG).show();
                return;
            }

            String firstName = firstNameEdit2.getText().toString();
            if(firstName.length() == 0) {
                Toast.makeText(getContext(), "Ime prazno.", Toast.LENGTH_LONG).show();
                return;
            }

            String lastName = lastNameEdit2.getText().toString();
            if(lastName.length() == 0) {
                Toast.makeText(getContext(), "Prezime prazno.", Toast.LENGTH_LONG).show();
                return;
            }

            String phoneNumber = phoneNumberEdit2.getText().toString();
            if(phoneNumber.length() == 0) {
                Toast.makeText(getContext(), "Broj telefona prazan.", Toast.LENGTH_LONG).show();
                return;
            }

            String address = addressEdit2.getText().toString();
            if(address.length() == 0) {
                Toast.makeText(getContext(), "Adresa prazna.", Toast.LENGTH_LONG).show();
                return;
            }

            String oldPassword = oldPasswordEdit.getText().toString();
            String newPassword = newPasswordEdit.getText().toString();
            String confirmedPassword = confirmedNewPassword.getText().toString();

            if(oldPassword.length() > 0){
                if(newPassword.length() == 0 || confirmedPassword.length() == 0){
                    Toast.makeText(getContext(), "Popunite sve lozinke.", Toast.LENGTH_LONG).show();
                    return;
                }
                if(!newPassword.equals(confirmedPassword)){
                    Toast.makeText(getContext(), "Potvrda lozinke nije dobra.", Toast.LENGTH_LONG).show();
                    return;
                }
            }


            String resp = User.changeUserData(User.currentUser.getUsername(),newUsername,firstName,lastName,phoneNumber,address,oldPassword,newPassword,confirmedPassword);

            if(resp.equals("OK")){
                Toast.makeText(getContext(),"Uspesna promena.",Toast.LENGTH_LONG).show();
                Navigation.findNavController(view2).navigate(R.id.action_changeUserDetailsFragment_to_profileFragment);
                return;
            }
            else{
                Toast.makeText(getContext(), resp,Toast.LENGTH_LONG).show();
                return;
            }
        });

    }
}