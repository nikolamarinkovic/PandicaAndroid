package com.example.pandica_anroid.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pandica_anroid.Models.Event;
import com.example.pandica_anroid.Models.SinglePacket;
import com.example.pandica_anroid.Models.User;
import com.example.pandica_anroid.R;

import java.util.List;

public class RecyclerAdapterEvents extends RecyclerView.Adapter<RecyclerAdapterEvents.MyViewHolder>{

    private List<Event> events;
    Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public RecyclerAdapterEvents(List<Event> events, Context context) {
        this.events = events;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private ImageView image;
        private TextView description;
        private ImageView likeImage;
        private TextView numberOfLikes;

        public MyViewHolder(@NonNull View view){
            super(view);
            name = view.findViewById(R.id.eventNameTextViewEventRecycler);
            image = view.findViewById(R.id.eventImageViewEventRecycler);
            description = view.findViewById(R.id.eventDescriptionTextViewEventRecycler);
            likeImage = view.findViewById(R.id.eventLikeImageViewEventRecycler);
            numberOfLikes = view.findViewById(R.id.eventNumberOfLikesTextViewEventRecycler);
        }
    }

    @NonNull
    @Override
    public RecyclerAdapterEvents.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.event,parent, false);
        return new RecyclerAdapterEvents.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterEvents.MyViewHolder holder, int position) {
        Event event = events.get(position);

        String name = event.getName();
        int imageResource = event.getImageResource();
        String description = event.getDescription();
        int numberOfLikes = event.getUserIdsLiked().size();

        int likeImageResource = R.drawable.not_liked;
        List<Integer> usersLiked = event.getUserIdsLiked();

        for(Integer id : usersLiked){
            if(id == User.currentUser.getId())
                likeImageResource = R.drawable.liked;
        }

        int eventId = event.getId();

        holder.name.setText(name);
        holder.image.setImageDrawable(context.getDrawable(imageResource));
        holder.description.setText(description);
        holder.likeImage.setImageDrawable(context.getDrawable(likeImageResource));
        holder.numberOfLikes.setText("" + numberOfLikes);

        holder.likeImage.setOnClickListener((view) -> {
            Event.currentUserLikeEvent(eventId);
            Drawable d = holder.likeImage.getDrawable();

            Bitmap b1 = ((BitmapDrawable) d).getBitmap();
            Bitmap b2 = ((BitmapDrawable) context.getDrawable(R.drawable.not_liked)).getBitmap();

            if(b1.equals(b2)){
                holder.likeImage.setImageDrawable(context.getDrawable(R.drawable.liked));
                int numOfLikes = Integer.parseInt(holder.numberOfLikes.getText().toString());
                holder.numberOfLikes.setText( numOfLikes + 1 + "");
            }
            else{
                holder.likeImage.setImageDrawable(context.getDrawable(R.drawable.not_liked));
                int numOfLikes = Integer.parseInt(holder.numberOfLikes.getText().toString());
                holder.numberOfLikes.setText( numOfLikes - 1 + "");
            }

        });
    }

    @Override
    public int getItemCount() {
        return events.size();
    }


}
