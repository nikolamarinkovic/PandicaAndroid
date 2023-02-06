package com.example.pandica_anroid.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pandica_anroid.Models.Packet;
import com.example.pandica_anroid.Models.SinglePacket;
import com.example.pandica_anroid.R;

import java.util.List;

public class RecyclerAdapterSingleTicketsBuyingTickets extends RecyclerView.Adapter<RecyclerAdapterSingleTicketsBuyingTickets.MyViewHolder>{

    private List<SinglePacket> singleTickets;
    Context context;

    public List<SinglePacket> getSingleTickets() {
        return singleTickets;
    }

    public void setSingleTickets(List<SinglePacket> singleTickets) {
        this.singleTickets = singleTickets;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public RecyclerAdapterSingleTicketsBuyingTickets(List<SinglePacket> singleTickets, Context context) {
        this.singleTickets = singleTickets;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView pricePerPerson;
        private EditText numberOfPeople;
        private TextView totalPrice;
        private TextView buyTextView;

        public MyViewHolder(@NonNull View view){
            super(view);
            name = view.findViewById(R.id.singlePacketNameTextViewSinglePacketsRecycler);
            pricePerPerson = view.findViewById(R.id.packetPricePerPersonTextViewSinglePacketsRecycler);
            numberOfPeople = view.findViewById(R.id.numberOfPeopleEditTextSinglePacketsRecycler);
            totalPrice = view.findViewById(R.id.totalPriceTextViewSinglePacketsRecycler);
            buyTextView = view.findViewById(R.id.buyPacketTextViewSinglePacketsRecycler);

        }
    }

    @NonNull
    @Override
    public RecyclerAdapterSingleTicketsBuyingTickets.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.single_packets,parent, false);
        return new RecyclerAdapterSingleTicketsBuyingTickets.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterSingleTicketsBuyingTickets.MyViewHolder holder, int position) {
        SinglePacket singlePacket = singleTickets.get(position);

        String name = singlePacket.getName();
        String pricePerPerson = Integer.toString(singlePacket.getPricePerPerson());
        int numberOfPpl = 0;
        int totalPrice = 0;

        int id = singlePacket.getId();

        holder.name.setText(name);
        holder.pricePerPerson.setText(pricePerPerson);
        holder.numberOfPeople.setText("" + numberOfPpl);
        holder.totalPrice.setText("" + totalPrice);

        holder.buyTextView.setOnClickListener((view) -> {
            //TODO: implement buying tickets
        });
    }

    @Override
    public int getItemCount() {
        return singleTickets.size();
    }


}
