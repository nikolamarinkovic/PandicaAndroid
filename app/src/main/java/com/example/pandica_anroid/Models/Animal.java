package com.example.pandica_anroid.Models;

import java.util.LinkedList;
import java.util.List;

public class Animal {

    public static List<Animal> animals;

    static {
        animals = new LinkedList<>();

        Animal a = new Animal(1,"Zirafa pera", "Zirafa pera", new LinkedList<>());
        //Comment c1 = new Comment()
        //a.comments.add()
        Animal b = new Animal(2, "Pingvin zika", "Pingvin zika", new LinkedList<>());

        animals.add(a);
        animals.add(b);
    }

    public Animal(){

    }

    public Animal(int id, String name, String description, List<Comment> comments) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.comments = comments;
    }

    private int id;
    private String name;
    private String description;
    private List<Comment> comments;


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