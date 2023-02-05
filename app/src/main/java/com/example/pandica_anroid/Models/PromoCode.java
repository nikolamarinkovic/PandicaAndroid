package com.example.pandica_anroid.Models;

import java.util.LinkedList;
import java.util.List;

public class PromoCode {

    public static List<PromoCode> promoCodes;

    static {
        promoCodes = new LinkedList<>();
    }

    private int id;
    private String name;
    private int discount;
    private int numberLeft;

    public PromoCode(int id, String name, int discount, int numberLeft) {
        this.id = id;
        this.name = name;
        this.discount = discount;
        this.numberLeft = numberLeft;
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

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getNumberLeft() {
        return numberLeft;
    }

    public void setNumberLeft(int numberLeft) {
        this.numberLeft = numberLeft;
    }
}
