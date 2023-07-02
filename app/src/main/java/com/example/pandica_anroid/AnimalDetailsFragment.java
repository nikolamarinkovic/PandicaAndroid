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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pandica_anroid.Adapters.RecyclerAdapterBoughtTickets;
import com.example.pandica_anroid.Adapters.RecyclerAdapterComments;
import com.example.pandica_anroid.Models.Animal;
import com.example.pandica_anroid.Models.BoughtTicket;
import com.example.pandica_anroid.Models.User;


public class AnimalDetailsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_animal_details, container, false);

        //setting title
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Pandica");

        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerViewPromoPackets = view.findViewById(R.id.recyclerViewCommentsAnimalDetails);

        recyclerViewPromoPackets.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewPromoPackets.setAdapter(new RecyclerAdapterComments( Animal.currentAnimal.getComments(), getContext()));

        ImageView animalImage = view.findViewById(R.id.animalImageAnimalDetails);
        animalImage.setImageDrawable(getActivity().getDrawable(Animal.currentAnimal.getImage()));

        TextView animalName  = view.findViewById(R.id.animalNameTextViewAnimalDetails);
        TextView animalDescription = view.findViewById(R.id.animalDescriptionAnimalDetails);

        animalName.setText(Animal.currentAnimal.getName());
        animalDescription.setText(Animal.currentAnimal.getDescription());

        boolean userCommented = User.userCommented();
        if(userCommented == true){
            //view.findViewById(R.id.layoutWhenUserHasNoCommentAnimalDetails).setVisibility(View.GONE);
            view.findViewById(R.id.postCommentButtonAnimalDetails).setVisibility(View.GONE);
            view.findViewById(R.id.userCommentEditTextAnimalDetails).setVisibility(View.GONE);
        }
        Button postCommentButton = view.findViewById(R.id.postCommentButtonAnimalDetails);
        EditText comment = view.findViewById(R.id.userCommentEditTextAnimalDetails);

        postCommentButton.setOnClickListener((view2) -> {
            if(comment.getText().toString().length() == 0){
                Toast.makeText(getContext(), "Komentar prazan", Toast.LENGTH_LONG).show();
                return;
            }
            User.currentUser.postComment(comment.getText().toString());
            Navigation.findNavController(getView()).navigate(R.id.action_animalDetailsFragment_self);

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
                Navigation.findNavController(getView()).navigate(R.id.action_animalDetailsFragment_to_buyingTicketsFragment);
                return true;
            case R.id.mainMenuBoughtTickets:
                Navigation.findNavController(getView()).navigate(R.id.action_animalDetailsFragment_to_boughtTicketsFragment);
                return true;
            case R.id.mainMenuEvents:
                Navigation.findNavController(getView()).navigate(R.id.action_animalDetailsFragment_to_eventsFragment);
                return true;
            case R.id.mainMenuAnimals:
                Navigation.findNavController(getView()).navigate(R.id.action_animalDetailsFragment_to_animalsFragment);
                return true;
            case R.id.mainMenuNotifications:
                Navigation.findNavController(getView()).navigate(R.id.action_animalDetailsFragment_to_notificationsFragment);
                return true;
            case R.id.mainMenuProfile:
                Navigation.findNavController(getView()).navigate(R.id.action_animalDetailsFragment_to_profileFragment);
                return true;

            case R.id.mainMenulogout:
                Navigation.findNavController(getView()).navigate(R.id.action_animalDetailsFragment_to_homeFragment);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}