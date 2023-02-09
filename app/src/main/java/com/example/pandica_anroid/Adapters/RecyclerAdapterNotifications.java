package com.example.pandica_anroid.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pandica_anroid.Models.Animal;
import com.example.pandica_anroid.Models.Notification;
import com.example.pandica_anroid.Models.User;
import com.example.pandica_anroid.R;

import java.util.Date;
import java.util.List;

public class RecyclerAdapterNotifications extends RecyclerView.Adapter<RecyclerAdapterNotifications.MyViewHolder>{

    private List<Notification> notifications;
    Context context;

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public RecyclerAdapterNotifications(List<Notification> notifications, Context context) {
        this.notifications = notifications;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView time;
        private TextView description;
        private TextView deleteButton;
        private View myView;

        public MyViewHolder(@NonNull View view){
            super(view);
            myView = view;
            time = view.findViewById(R.id.notificationTimeTextViewNotificationRecycler);
            description = view.findViewById(R.id.notificationDescriptionTextViewNotificationRecycler);
            deleteButton = view.findViewById(R.id.deleteNotificationTextViewRecyclerViewNotifications);
        }
    }

    @NonNull
    @Override
    public RecyclerAdapterNotifications.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.notification,parent, false);
        return new RecyclerAdapterNotifications.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterNotifications.MyViewHolder holder, int position) {
        Notification notif = notifications.get(position);

        Date date = notif.getTime();
        String description = notif.getContent();
        int notifId = notif.getId();

        holder.time.setText("" + date.getDate() + "." + date.getMonth() + "." + date.getYear() + "\n" + date.getHours() + ":" + date.getMinutes());
        holder.description.setText(description);

        holder.deleteButton.setOnClickListener((view) -> {
            User.deleteNotificationFromCurrentUser(notifId);
            Navigation.findNavController(holder.myView).navigate(R.id.action_notificationsFragment_self);

        });

    }


        @Override
        public int getItemCount() {
            return notifications.size();
        }


}
