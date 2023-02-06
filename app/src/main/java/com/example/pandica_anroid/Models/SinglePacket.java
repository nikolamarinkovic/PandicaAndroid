package com.example.pandica_anroid.Models;

import java.util.LinkedList;
import java.util.List;

public class SinglePacket {

    public static List<SinglePacket> singlePackets;

    static {
        singlePackets = new LinkedList<>();
        SinglePacket singlePacket = new SinglePacket(1, "Pojedinačna karta", 400);
        singlePackets.add(singlePacket);
    }

    private int id;
    private String name;
    private int pricePerPerson;

    private SinglePacket(int id, String name, int pricePerPerson) {
        this.id = id;
        this.name = name;
        this.pricePerPerson = pricePerPerson;
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

    public int getPricePerPerson() {
        return pricePerPerson;
    }

    public void setPricePerPerson(int pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }
}
