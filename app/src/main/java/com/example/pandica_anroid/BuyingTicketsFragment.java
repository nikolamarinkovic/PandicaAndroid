package com.example.pandica_anroid;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pandica_anroid.Adapters.RecyclerAdapterPromoPackagesBuyingTickets;
import com.example.pandica_anroid.Adapters.RecyclerAdapterSingleTicketsBuyingTickets;
import com.example.pandica_anroid.Models.Packet;
import com.example.pandica_anroid.Models.SinglePacket;

import java.util.List;

public class BuyingTicketsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buying_tickets, container, false);

        //setting title
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Pandica");

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

    }


}