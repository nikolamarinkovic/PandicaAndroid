package com.example.pandica_anroid.Models;

import java.util.LinkedList;
import java.util.List;

public class Packet {

    public static List<Packet> packets;

    static {
        packets = new LinkedList<>();

        packets.add(new Packet(1, "test1", 25, 25, "sds"));
        packets.add(new Packet(2, "test2", 25, 25, "sds"));
        packets.add(new Packet(3, "test3", 25, 25, "sds"));
        packets.add(new Packet(4, "tes4", 25, 25, "sds"));


    }

    private int id;
    private String name;
    private int price;
    private int numberOfPeople;
    private String description;

    public Packet(int id, String name, int price, int numberOfPeople, String description) {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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
