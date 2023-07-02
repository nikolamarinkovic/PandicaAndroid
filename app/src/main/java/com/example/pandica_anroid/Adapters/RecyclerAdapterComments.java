package com.example.pandica_anroid.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pandica_anroid.Models.Animal;
import com.example.pandica_anroid.Models.Comment;
import com.example.pandica_anroid.Models.User;
import com.example.pandica_anroid.R;

import java.util.List;

public class RecyclerAdapterComments extends RecyclerView.Adapter<RecyclerAdapterComments.MyViewHolder>{

    private List<Comment> comments;
    Context context;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public RecyclerAdapterComments(List<Comment> comments, Context context) {
        this.comments = comments;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView usernameTextView;

        private TextView commentContentTextView;
        private AppCompatButton deleteButton;
        private AppCompatButton startChangeButton;

        private EditText changedComment;
        private AppCompatButton submitChangeButton;
        private AppCompatButton cancelChangeButton;

        private View myView;

        public MyViewHolder(@NonNull View view){
            super(view);

            myView = view;
            usernameTextView = view.findViewById(R.id.commentUsernameTextViewCommentRecycler);

            commentContentTextView = view.findViewById(R.id.commentContentTextViewCommentRecycler);
            startChangeButton = view.findViewById(R.id.changeCommentButtonCommentRecycler);
            deleteButton = view.findViewById(R.id.deleteCommentButtonCommentRecycler);

            changedComment = view.findViewById(R.id.editCommentEditTextCommentRecycler);
            submitChangeButton = view.findViewById(R.id.confirmCommentChangeButtonCommentRecycler);
            cancelChangeButton = view.findViewById(R.id.cancelCommentChangeButtonCommentRecycler);
        }
    }

    @NonNull
    @Override
    public RecyclerAdapterComments.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.comment,parent, false);
        return new RecyclerAdapterComments.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterComments.MyViewHolder holder, int position) {
        Comment comment = comments.get(position);

        int userID = comment.getUserId();
        User user = User.getUserFromId(userID);

        holder.usernameTextView.setText(user.getUsername());
        holder.commentContentTextView.setText(comment.getContent());


        holder.changedComment.setVisibility(View.GONE);
        holder.submitChangeButton.setVisibility(View.GONE);
        holder.cancelChangeButton.setVisibility(View.GONE);

        if(User.currentUser.getId() != userID){
            holder.startChangeButton.setVisibility(View.GONE);
            holder.deleteButton.setVisibility(View.GONE);
            return;
        }


        holder.startChangeButton.setOnClickListener((view2) -> {

            holder.changedComment.setText(comment.getContent());

            holder.changedComment.setVisibility(View.VISIBLE);
            holder.submitChangeButton.setVisibility(View.VISIBLE);
            holder.cancelChangeButton.setVisibility(View.VISIBLE);

            holder.commentContentTextView.setVisibility(View.GONE);
            holder.startChangeButton.setVisibility(View.GONE);
            holder.deleteButton.setVisibility(View.GONE);


        });

        holder.deleteButton.setOnClickListener((view2) -> {
            User.currentUser.deleteCommentFromCurrentAnimal();
            Navigation.findNavController(holder.myView).navigate(R.id.action_animalDetailsFragment_self);
        });

        holder.submitChangeButton.setOnClickListener((view2) -> {
            if(holder.changedComment.getText().toString().length() == 0){
                Toast.makeText(context, "Komentar prazan.", Toast.LENGTH_LONG).show();
                return;
            }

            User.currentUser.changeComment(holder.changedComment.getText().toString());
            Navigation.findNavController(holder.myView).navigate(R.id.action_animalDetailsFragment_self);
        });

        holder.cancelChangeButton.setOnClickListener((view2) -> {
            holder.commentContentTextView.setText(comment.getContent());

            holder.changedComment.setVisibility(View.GONE);
            holder.submitChangeButton.setVisibility(View.GONE);
            holder.cancelChangeButton.setVisibility(View.GONE);

            holder.commentContentTextView.setVisibility(View.VISIBLE);
            holder.startChangeButton.setVisibility(View.VISIBLE);
            holder.deleteButton.setVisibility(View.VISIBLE);
        });
    }


        @Override
        public int getItemCount() {
            return comments.size();
        }


}
