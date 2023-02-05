package com.example.pandica_anroid.Models;

import java.util.LinkedList;
import java.util.List;

public class Packet {

    public static List<Packet> packets;

    static {
        packets = new LinkedList<>();
    }

    private int id;
    private String name;
    private float price;
    private int numberOfPeople;
    private String description;

    public Packet(int id, String name, float price, int numberOfPeople, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.numberOfPeople = numberOfPeople;
        this.description = description;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
