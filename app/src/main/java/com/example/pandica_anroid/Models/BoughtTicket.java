package com.example.pandica_anroid.Models;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class BoughtTicket {

    public static List<BoughtTicket> boughtTickets;
    public static List<BoughtTicket> userBoughtTickets;

    static {
        userBoughtTickets = new LinkedList<>();
        boughtTickets = new LinkedList<>();

        BoughtTicket b1 = new BoughtTicket(0, 0, "Porodicna", 4, 1200, 1, new Date(2022,11,10),true,-1,"",0);
        BoughtTicket b2 = new BoughtTicket(1, 0, "Regularna", 2, 1200, 2, new Date(2022,11,10),true,-1,"",0);
        BoughtTicket b3 = new BoughtTicket(2, 0, "Ucenicka", 1, 1200, 0, new Date(2022,11,10),true,-1,"",0);

        BoughtTicket c1 = new BoughtTicket(3, 1, "Porodicna2", 4, 1200, 1, new Date(2022,11,10),true,-1,"",0);

        boughtTickets.add(b1);
        boughtTickets.add(b2);
        boughtTickets.add(b3);

        boughtTickets.add(c1);
    }

    public static void initUserBoughtTickets(int userId){
        userBoughtTickets.clear();
        for(int i = 0; i < boughtTickets.size(); i++){
            BoughtTicket ticket = boughtTickets.get(i);
            if(ticket.userId == userId && ticket.status != 3)
                userBoughtTickets.add(ticket);
        }

    }

    private int id;
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

    public BoughtTicket(int id, int userId, String name, int numberOfPeople, int totalPrice, int status, Date date, boolean isPromoPacket, int promoCodeId, String promoCodeName, int promoCodeDiscount) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
