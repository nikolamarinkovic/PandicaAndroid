package com.example.pandica_anroid.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pandica_anroid.Models.BoughtTicket;
import com.example.pandica_anroid.R;

import java.util.Date;
import java.util.List;

public class RecyclerAdapterBoughtTickets extends RecyclerView.Adapter<RecyclerAdapterBoughtTickets.MyViewHolder>{

    private List<BoughtTicket> boughtTickets;
    Context context;

    public List<BoughtTicket> getBoughtTickets() {
        return boughtTickets;
    }

    public void setBoughtTickets(List<BoughtTicket> boughtTickets) {
        this.boughtTickets = boughtTickets;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public RecyclerAdapterBoughtTickets(List<BoughtTicket> boughtTickets, Context context) {
        this.boughtTickets = boughtTickets;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView numberOfPeople;
        private TextView totalPrice;
        private TextView status;
        private TextView date;
        private TextView cancelTextView;
        private View view;

        public MyViewHolder(@NonNull View view){
            super(view);

            this.view = view;
            name = view.findViewById(R.id.boughtTicketNameTextViewRecyclerViewBoughtTicket);
            numberOfPeople = view.findViewById(R.id.boughtTicketNumberOfPeopleTextViewRecyclerViewBoughtTicket);
            totalPrice = view.findViewById(R.id.boughtTicketPriceTextViewRecyclerViewBoughtTicket);
            status = view.findViewById(R.id.boughtTicketStatusTextViewRecyclerViewBoughtTicket);
            date = view.findViewById(R.id.boughtTicketDateRecyclerViewBoughtTicket);
            cancelTextView = view.findViewById(R.id.cancelBoughtTicketRecyclerViewBoughtTicket);

        }
    }

    @NonNull
    @Override
    public RecyclerAdapterBoughtTickets.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.bought_tickets,parent, false);
        return new RecyclerAdapterBoughtTickets.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterBoughtTickets.MyViewHolder holder, int position) {
        BoughtTicket boughtTicket = boughtTickets.get(position);

        String name = boughtTicket.getName();
        int numberOfPpl = boughtTicket.getNumberOfPeople();
        int totalPrice = boughtTicket.getTotalPrice();
        int statusInt = boughtTicket.getStatus();
        String status = "";
        Date date = boughtTicket.getDate();

        holder.name.setText(name);
        holder.numberOfPeople.setText("" + numberOfPpl);
        holder.totalPrice.setText("" + totalPrice);

        if (statusInt == 0) {
            status = "Na cekanju";
            holder.status.setBackgroundResource(R.color.status_ticket_on_wait);
            holder.cancelTextView.setOnClickListener((view) -> {
                BoughtTicket.cancelTicket(boughtTicket.getId());
                Navigation.findNavController(holder.view).navigate(R.id.action_boughtTicketsFragment_self);
            });
        } else if (statusInt == 1) {
            status = "Odobreno";
            holder.status.setBackgroundResource(R.color.status_ticket_accepted);
            holder.cancelTextView.setBackgroundResource(R.color.disabled_button);
        } else if (statusInt == 2) {
            status = "Odbijeno";
            holder.status.setBackgroundResource(R.color.status_ticket_declined);
            holder.cancelTextView.setBackgroundResource(R.color.disabled_button);
        }

        holder.status.setText(status);
        holder.date.setText("" + date.getDate() + "." + date.getMonth() + "." + date.getYear());

        int id = boughtTicket.getId();
    }


        @Override
        public int getItemCount() {
            return boughtTickets.size();
        }


}
