package com.example.pandica_anroid.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pandica_anroid.Models.Animal;
import com.example.pandica_anroid.Models.BoughtTicket;
import com.example.pandica_anroid.R;

import java.util.Date;
import java.util.List;

public class RecyclerAdapterAnimals extends RecyclerView.Adapter<RecyclerAdapterAnimals.MyViewHolder>{

    private List<Animal> animals;
    Context context;

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public RecyclerAdapterAnimals(List<Animal> animals, Context context) {
        this.animals = animals;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private ImageView image;
        private Button detailsButton;

        public MyViewHolder(@NonNull View view){
            super(view);
            name = view.findViewById(R.id.animalNameTextViewAnimalRecycler);
            image = view.findViewById(R.id.animalImageViewAnimalRecycler);
            detailsButton = view.findViewById(R.id.detailsButtonAnimalRecycler);
        }
    }

    @NonNull
    @Override
    public RecyclerAdapterAnimals.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.animal,parent, false);
        return new RecyclerAdapterAnimals.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterAnimals.MyViewHolder holder, int position) {
        Animal animal = animals.get(position);

        String name = animal.getName();
        int drawableRes = animal.getImage();

        int id = animal.getId();


        holder.name.setText(name);
        holder.image.setImageDrawable(context.getDrawable(drawableRes));

        holder.detailsButton.setOnClickListener((view) -> {
            //TODO: add navigtation to details
        });

    }


        @Override
        public int getItemCount() {
            return animals.size();
        }


}
