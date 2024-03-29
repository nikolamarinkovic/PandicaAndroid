package com.example.pandica_anroid;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.pandica_anroid.Adapters.RecyclerAdapterPromoPackagesBuyingTickets;
import com.example.pandica_anroid.Adapters.RecyclerAdapterSingleTicketsBuyingTickets;
import com.example.pandica_anroid.Models.BoughtTicket;
import com.example.pandica_anroid.Models.Packet;
import com.example.pandica_anroid.Models.SinglePacket;

import java.util.List;

public class BuyingTicketsFragment extends Fragment {

    public static EditText promoCode;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buying_tickets, container, false);

        //setting title
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Pandica");

        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerViewPromoPackets = view.findViewById(R.id.recyclerViewPromoPacketsBuyingTickets);

        recyclerViewPromoPackets.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewPromoPackets.setAdapter(new RecyclerAdapterPromoPackagesBuyingTickets( Packet.packets, getContext()));

        RecyclerView recyclerViewSingleTickets = view.findViewById(R.id.recyclerViewSingleTicketsBuyingTickets);

        recyclerViewSingleTickets.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewSingleTickets.setAdapter(new RecyclerAdapterSingleTicketsBuyingTickets( SinglePacket.singlePackets, getContext()));

        BuyingTicketsFragment.promoCode = getActivity().findViewById(R.id.promoCodeEditTextBuyingTickets);
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

                return true;
            case R.id.mainMenuBoughtTickets:
                Navigation.findNavController(getView()).navigate(R.id.action_buyingTicketsFragment_to_boughtTicketsFragment);
                return true;
            case R.id.mainMenuEvents:
                Navigation.findNavController(getView()).navigate(R.id.action_buyingTicketsFragment_to_eventsFragment);
                return true;
            case R.id.mainMenuAnimals:
                Navigation.findNavController(getView()).navigate(R.id.action_buyingTicketsFragment_to_animalsFragment);
                return true;
            case R.id.mainMenuNotifications:
                Navigation.findNavController(getView()).navigate(R.id.action_buyingTicketsFragment_to_notificationsFragment);
                return true;
            case R.id.mainMenuProfile:
                Navigation.findNavController(getView()).navigate(R.id.action_buyingTicketsFragment_to_profileFragment);
                return true;

            case R.id.mainMenulogout:
                Navigation.findNavController(getView()).navigate(R.id.action_buyingTicketsFragment_to_homeFragment);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}