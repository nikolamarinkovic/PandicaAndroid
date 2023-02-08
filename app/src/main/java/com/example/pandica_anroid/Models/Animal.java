package com.example.pandica_anroid.Models;

import com.example.pandica_anroid.R;

import java.util.LinkedList;
import java.util.List;

public class Animal {

    public static List<Animal> animals;

    static {
        animals = new LinkedList<>();
        //TODO: prepraviti ovo
        Animal a = new Animal(0,"Zirafa pera", "Zirafa pera", new LinkedList<>(), R.drawable.animal_0);
        //Comment c1 = new Comment()
        //a.comments.add()
        Animal b = new Animal(1, "Pingvin zika", "Pingvin zika", new LinkedList<>(),R.drawable.event_0);
        Animal c = new Animal(1, "Pingvin zika", "Pingvin zika", new LinkedList<>(),R.drawable.event_0);

        animals.add(a);
        animals.add(b);
        animals.add(c);
    }

    public Animal(){

    }

    public Animal(int id, String name, String description, List<Comment> comments, int imageResource) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.comments = comments;
        this.imageResource = imageResource;
    }

    private int id;
    private String name;
    private String description;
    private List<Comment> comments;
    private int imageResource;

    public int getImage() {
        return imageResource;
    }

    public void setImage(int imageResource) {
        this.imageResource = imageResource;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
