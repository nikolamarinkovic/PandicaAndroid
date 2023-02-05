package com.example.pandica_anroid.Models;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class User {

    public static List<User> users;

    static {
        users = new LinkedList<>();

        User userPera = new User( "pera","pera", "user", "Perica", "Peric", "555-333", "Pere Velimirovica 35c");
        User userMika = new User("mika","mika", "user", "Perica", "Peric", "555-333", "Pere Velimirovica 35c");

        users.add(userPera);
        users.add(userMika);
    }

    private int id;
    private String username;
    private String password;
    private String userType;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private int approved; // only used for employees, 0 - needs admin to approve/reject, 1 - approve, 2 - reject
    private List<Notification> notifications;
    private List<Integer> usedPromoCodes;

    public User(String username, String password, String userType, String firstName, String lastName, String phoneNumber, String address) {

        int newId = 0;
        for(User u: User.users){
            if(u.id >= newId)
                newId = u.id + 1;
        }

        this.id = newId;

        this.username = username;
        this.password = password;
        this.userType = userType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.approved = 0;
        this.notifications = new LinkedList<>();
        this.usedPromoCodes = new LinkedList<>();
    }

    public static boolean loginCredentialsGood(String username, String password){
        for(User e: users){
            if(e.username.equals(username) && e.password.equals(password) && e.userType.equals("user"))
                return true;
        }
        return false;
    }

    public static String registerNewUser(String username, String password, String confirmedPassword, String userType, String firstName, String lastName, String phoneNumber, String address){

        if(username.length() == 0 || password.length() == 0 || confirmedPassword.length() == 0 || userType.length() == 0 || firstName.length() == 0 || lastName.length() == 0 || phoneNumber.length() == 0 || address.length() == 0){
            return "Popunite sva polja.";
        }
        if(!password.equals(confirmedPassword)){
            return "Sifre se ne poklapaju";
        }

        boolean foundSameUsername = false;

        for(User u: users){
            if(u.username.equals( username))
                foundSameUsername = true;
        }

        if(foundSameUsername == true){
            return "Postoji korisnik sa istim korisnickim imenom.";
        }



        User user = new User(username,password,"user",firstName, lastName, phoneNumber, address);

        users.add(user);
        return "OK";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getApproved() {
        return approved;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public List<Integer> getUsedPromoCodes() {
        return usedPromoCodes;
    }

    public void setUsedPromoCodes(List<Integer> usedPromoCodes) {
        this.usedPromoCodes = usedPromoCodes;
    }
}
