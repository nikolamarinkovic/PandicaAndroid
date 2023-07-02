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

        BoughtTicket c1 = new BoughtTicket(3, 1, "Porodicna", 4, 1200, 1, new Date(2022,11,10),true,-1,"",0);

        boughtTickets.add(b1);
        boughtTickets.add(b2);
        boughtTickets.add(b3);

        boughtTickets.add(c1);
    }

    public static void cancelTicket(int ticketId){
        for(BoughtTicket ticket: BoughtTicket.boughtTickets){
            if(ticket.id == ticketId){
                ticket.status = 3;

                int promoCodeId = ticket.getPromoCodeId();
                int i = 0;
                for(int code: User.currentUser.getUsedPromoCodes()){
                    if(code == promoCodeId){
                        User.currentUser.getUsedPromoCodes().remove(i);
                        PromoCode.cancelUse(promoCodeId);
                        break;
                    }
                    i++;
                }

                initUserBoughtTickets(User.currentUser.getId());
                return;
            }
        }
    }

    public static String buyPacket(int packetId, String promoCode, boolean force){ // force flag is for when a user enters promo code buy cant use it

        Packet packet = null;
        for(Packet p : Packet.packets){
            if(p.getId() == packetId){
                packet = p;
                break;
            }
        }
        if(packet == null){
            return "Greska";
        }

        int promoCodeDiscount = 0;
        int promoCodeId = -1;
        String promoCodeName = "";
        PromoCode code = null;

        if(promoCode.length() > 0 && force == false){
            for(PromoCode p : PromoCode.promoCodes){
                if(p.getName().equals(promoCode)){
                    code = p;
                    break;
                }
            }

            if(code == null){
                return " Promo kod ne postoji."; // the extra space at start is for the recycler to parse
            }
            if(code.getNumberLeft() <= 0){
                return " Promo kod istekao.";
            }
            for( int usedCode : User.currentUser.getUsedPromoCodes()){
                if(usedCode == code.getId()){
                    return " Iskoristili ste kod.";
                }
            }

            promoCodeId=code.getId();
            promoCodeName=code.getName();
            promoCodeDiscount = code.getDiscount();

            code.setNumberLeft(code.getNumberLeft() - 1);

            User.currentUser.getUsedPromoCodes().add(code.getId());

        }

        int newId = 0;
        for(BoughtTicket t: boughtTickets){
            if(t.getId() >= newId)
                newId = t.getId() + 1;
        }

        int totalPrice = (int) (Math.floor((packet.getPrice() * 1.0 * (100-promoCodeDiscount))/100));

        BoughtTicket boughtTicket = new BoughtTicket(newId, User.currentUser.getId(), packet.getName(), packet.getNumberOfPeople(), totalPrice, 0, new Date(), true, promoCodeId, promoCodeName,promoCodeDiscount);
        BoughtTicket.boughtTickets.add(boughtTicket);
        BoughtTicket.initUserBoughtTickets(User.currentUser.getId());
        return "Uspesno kupljeno";
    }

    public static String buySinglePacket(int singlePacketId, int numberOfPeople, String promoCode, boolean force){ // force flag is for when a user enters promo code buy cant use it

        SinglePacket singlePacket = null;
        for(SinglePacket s : SinglePacket.singlePackets){
            if(s.getId() == singlePacketId){
                singlePacket = s;
                break;
            }
        }
        if(singlePacket == null){
            return "Greska";
        }

        int promoCodeDiscount = 0;
        int promoCodeId = -1;
        String promoCodeName = "";
        PromoCode code = null;

        if(promoCode.length() > 0 && force == false){
            for(PromoCode p : PromoCode.promoCodes){
                if(p.getName().equals(promoCode)){
                    code = p;
                    break;
                }
            }

            if(code == null){
                return " Promo kod ne postoji."; // the extra space at start is for the recycler to parse
            }
            if(code.getNumberLeft() <= 0){
                return " Promo kod istekao.";
            }
            for( int usedCode : User.currentUser.getUsedPromoCodes()){
                if(usedCode == code.getId()){
                    return " Iskoristili ste kod.";
                }
            }

            promoCodeId=code.getId();
            promoCodeName=code.getName();
            promoCodeDiscount = code.getDiscount();

            code.setNumberLeft(code.getNumberLeft() - 1);

            User.currentUser.getUsedPromoCodes().add(code.getId());

        }

        int newId = 0;
        for(BoughtTicket t: boughtTickets){
            if(t.getId() >= newId)
                newId = t.getId() + 1;
        }

        int totalPrice = (int) (Math.floor((singlePacket.getPricePerPerson() * numberOfPeople * 1.0 * (100-promoCodeDiscount))/100));

        BoughtTicket boughtTicket = new BoughtTicket(newId, User.currentUser.getId(), singlePacket.getName(), numberOfPeople, totalPrice, 0, new Date(), false, promoCodeId, promoCodeName,promoCodeDiscount);
        BoughtTicket.boughtTickets.add(boughtTicket);
        BoughtTicket.initUserBoughtTickets(User.currentUser.getId());
        return "Uspesno kupljeno";
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
