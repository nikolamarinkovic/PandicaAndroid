package com.example.pandica_anroid.Models;

import com.example.pandica_anroid.R;

import java.util.LinkedList;
import java.util.List;

public class Event {

    public static List<Event> events;

    static {
        events = new LinkedList<>();

        Event e = new Event(0, "Pandica Jovan dosao", "Doso pandica jovan", new LinkedList<>(), R.drawable.event_0);
        events.add(e);
    }

    private int id;
    private String name;
    private String description;
    private List<Integer> userIdsLiked;
    private int imageResource;

    public Event(int id, String name, String description, List<Integer> userIdsLiked, int imageResource) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.userIdsLiked = userIdsLiked;
        this.imageResource = imageResource;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
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

    public List<Integer> getUserIdsLiked() {
        return userIdsLiked;
    }

    public void setUserIdsLiked(List<Integer> userIdsLiked) {
        this.userIdsLiked = userIdsLiked;
    }
}
