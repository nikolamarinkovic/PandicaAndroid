package com.example.pandica_anroid.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pandica_anroid.Models.Packet;
import com.example.pandica_anroid.R;

import java.util.List;

public class RecyclerAdapterPromoPackagesBuyingTickets extends RecyclerView.Adapter<RecyclerAdapterPromoPackagesBuyingTickets.MyViewHolder> {

    private List<Packet> packets;
    Context context;

    public List<Packet> getPackets() {
        return packets;
    }

    public void setPackets(List<Packet> packets) {
        this.packets = packets;
    }

    public RecyclerAdapterPromoPackagesBuyingTickets(List<Packet> packets, Context context) {
        this.packets = packets;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView price;
        private TextView numberOfPeople;
        private TextView description;
        private TextView buyTextView;

        public MyViewHolder(@NonNull View view){
            super(view);
            name = view.findViewById(R.id.packetNameTextViewPromoPacketRecycler);
            price = view.findViewById(R.id.packetPriceTextViewPromoPacketRecycler);
            numberOfPeople = view.findViewById(R.id.packetNumberOfPeopleTextViewPromoPacketRecycler);
            description = view.findViewById(R.id.packetDescriptionTextViewPromoPacketRecycler);
            buyTextView = view.findViewById(R.id.buyPacketTextViewPromoPacketRecycler);

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View itemView = LayoutInflater.from(context).inflate(R.layout.promo_packets,parent, false);
       return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Packet packet = packets.get(position);

        String name = packet.getName();
        String price = Integer.toString(packet.getPrice());
        String numberOfPpl = Integer.toString(packet.getNumberOfPeople());
        String description = packet.getDescription();
        int id = packet.getId();

        holder.name.setText(name);
        holder.price.setText(price);
        holder.numberOfPeople.setText(numberOfPpl);
        holder.description.setText(description);

        holder.buyTextView.setOnClickListener((view) -> {
            //TODO: implement buying tickets
        });
    }

    @Override
    public int getItemCount() {
        return packets.size();
    }


}
