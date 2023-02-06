package com.example.pandica_anroid.Models;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class BoughtTicket {

    public static List<BoughtTicket> boughtTickets;

    static {
        boughtTickets = new LinkedList<>();
    }

    private int Number;
    private int userId;
    private String name;
    private int numberOfPeople;
    private int totalPrice;
    private int status; //0 - on wait, 1 - approved, 2 - denied, 3 - canceled
    private Date date;
    private boolean isPromoPacket;
    private int promoCodeId;
    private String promoCodeName;
    private int promoCodeDiscount;

    public BoughtTicket(int number, int userId, String name, int numberOfPeople, int totalPrice, int status, Date date, boolean isPromoPacket, int promoCodeId, String promoCodeName, int promoCodeDiscount) {
        Number = number;
        this.userId = userId;
        this.name = name;
        this.numberOfPeople = numberOfPeople;
        this.totalPrice = totalPrice;
        this.status = status;
        this.date = date;
        this.isPromoPacket = isPromoPacket;
        this.promoCodeId = promoCodeId;
        this.promoCodeName = promoCodeName;
        this.promoCodeDiscount = promoCodeDiscount;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isPromoPacket() {
        return isPromoPacket;
    }

    public void setPromoPacket(boolean promoPacket) {
        isPromoPacket = promoPacket;
    }

    public int getPromoCodeId() {
        return promoCodeId;
    }

    public void setPromoCodeId(int promoCodeId) {
        this.promoCodeId = promoCodeId;
    }

    public String getPromoCodeName() {
        return promoCodeName;
    }

    public void setPromoCodeName(String promoCodeName) {
        this.promoCodeName = promoCodeName;
    }

    public int getPromoCodeDiscount() {
        return promoCodeDiscount;
    }

    public void setPromoCodeDiscount(int promoCodeDiscount) {
        this.promoCodeDiscount = promoCodeDiscount;
    }
}
