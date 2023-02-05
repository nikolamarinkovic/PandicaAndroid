package com.example.pandica_anroid.Models;

import java.util.LinkedList;
import java.util.List;

public class Event {

    public static List<Event> events;

    static {
        events = new LinkedList<>();
    }

    private int id;
    private String name;
    private String description;
    private List<Number> userIdsLiked;

    public Event(int id, String name, String description, List<Number> userIdsLiked) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.userIdsLiked = userIdsLiked;
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

    public List<Number> getUserIdsLiked() {
        return userIdsLiked;
    }

    public void setUserIdsLiked(List<Number> userIdsLiked) {
        this.userIdsLiked = userIdsLiked;
    }
}
