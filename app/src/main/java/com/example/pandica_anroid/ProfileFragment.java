package com.example.pandica_anroid;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pandica_anroid.Adapters.RecyclerAdapterPromoPackagesBuyingTickets;
import com.example.pandica_anroid.Adapters.RecyclerAdapterSingleTicketsBuyingTickets;
import com.example.pandica_anroid.Models.Packet;
import com.example.pandica_anroid.Models.SinglePacket;
import com.example.pandica_anroid.Models.User;


public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        //setting title
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Pandica");

        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView username =  view.findViewById(R.id.profileUsernameValueTextViewProfile);
        TextView firstName = view.findViewById(R.id.profileFirstNameValueTextViewProfile);
        TextView lastName =  view.findViewById(R.id.profileLastNameValueTextViewProfile);
        TextView phoneNumber = view.findViewById(R.id.profilePhoneNumberValueTextViewProfile);
        TextView address =  view.findViewById(R.id.profileAddressValueTextViewProfile);

        TextView buttonChange = view.findViewById(R.id.profileChangeButtonNotifications);

        username.setText("  " + User.currentUser.getUsername());
        firstName.setText("  " + User.currentUser.getFirstName());
        lastName.setText("  " + User.currentUser.getLastName());
        phoneNumber.setText("  " + User.currentUser.getPhoneNumber());
        address.setText("  " + User.currentUser.getAddress());

        int id = User.currentUser.getId();

        buttonChange.setOnClickListener((view2) -> {
            Navigation.findNavController(getView()).navigate(R.id.action_profileFragment_to_changeUserDetailsFragment);
        });

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        menu.clear();
        getActivity().getMenuInflater().inflate(R.menu.main_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        switch (item.getItemId()){
            case R.id.mainMenuBuyingTickets:
                Navigation.findNavController(getView()).navigate(R.id.action_profileFragment_to_buyingTicketsFragment);
                return true;
            case R.id.mainMenuBoughtTickets:
                Navigation.findNavController(getView()).navigate(R.id.action_profileFragment_to_boughtTicketsFragment);
                return true;
            case R.id.mainMenuEvents:
                Navigation.findNavController(getView()).navigate(R.id.action_profileFragment_to_eventsFragment);
                return true;
            case R.id.mainMenuAnimals:
                Navigation.findNavController(getView()).navigate(R.id.action_profileFragment_to_animalsFragment);
                return true;
            case R.id.mainMenuNotifications:
                Navigation.findNavController(getView()).navigate(R.id.action_profileFragment_to_notificationsFragment);
                return true;
            case R.id.mainMenuProfile:
                return true;
            case R.id.mainMenulogout:
                Navigation.findNavController(getView()).navigate(R.id.action_profileFragment_to_homeFragment);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}