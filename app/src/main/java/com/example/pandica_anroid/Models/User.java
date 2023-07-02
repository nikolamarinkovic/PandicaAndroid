package com.example.pandica_anroid.Models;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class User {

    public static List<User> users;
    public static User currentUser = null;

    static {
        users = new LinkedList<>();

        User userPera = new User( "pera","pera", "user", "Perica", "Peric", "555-333", "Pere Velimirovica 35c");
        Notification n = new Notification(1,"test", new Date(2022,10,10,15,20));
        userPera.getNotifications().add(n);
        users.add(userPera);

        User userMika = new User("mika","mika", "user", "Perica", "Peric", "555-333", "Pere Velimirovica 35c");
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

    public static String changeUserData(String oldUsername, String newUsername, String newFirstName, String newLastname, String newPhoneNumber, String newAddress, String oldPassword, String newPassword, String newPasswordConfirmed){

        boolean oldUsernameFound = false;
        boolean newUserNameFound = false;
        User user = null;
        for(User u: User.users){
            if(u.username.equals(oldUsername)) {
                oldUsernameFound = true;
                user = u;
            }
            if(u.username.equals(newUsername) && !newUsername.equals(oldUsername) )
                newUserNameFound = true;
        }
        if(oldUsernameFound == false){
            return "Greska.";
        }
        if(newUserNameFound == true)
            return "Novo koriscnicko ime postoji.";

        if(oldPassword.length() > 0){
            if(!user.getPassword().equals(oldPassword)){
                return "Stara lozinka nije dobra.";
            }
            if(newPassword.length() == 0){
                return "Nova lozinka prazna.";
            }
            if(newPasswordConfirmed.length() == 0)
                return "Potvrda lozinke prazna.";
            if(!newPassword.equals(newPasswordConfirmed))
                return "Potvrda lozinke nije dobra.";

            user.setPassword(newPassword);
        }

        user.setUsername(newUsername);
        user.setFirstName(newFirstName);
        user.setLastName(newLastname);
        user.setPhoneNumber(newPhoneNumber);
        user.setAddress(newAddress);


        return "OK";
    }

    public static void deleteNotificationFromCurrentUser(int notifId){
        int index = 0;
        boolean found = false;
        for(Notification notif: User.currentUser.getNotifications()){
            if(notif.getId() == notifId){
                found = true;
                break;
            }
            index++;
        }
        if(found == false)
            return;
        User.currentUser.getNotifications().remove(index);
        return;

    }

    public static boolean loginCredentialsGood(String username, String password){
        for(User e: users){
            if(e.username.equals(username) && e.password.equals(password) && e.userType.equals("user")) {
                currentUser = e;
                BoughtTicket.initUserBoughtTickets(e.id);
                return true;
            }
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

    public static User getUserFromId(int userID) {
        for(User u: User.users){
            if(u.getId() == userID)
                return u;
        }
        return null;
    }

    public static boolean userCommented() {
        Animal currentAnimal = Animal.currentAnimal;
        User currentUser = User.currentUser;

        for(Comment c: currentAnimal.getComments()){
            if(c.getUserId() == currentUser.getId())
                return true;
        }
        return false;
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

    public void deleteCommentFromCurrentAnimal() {
        int i = 0;
        int userID = User.currentUser.getId();
        Animal animal = Animal.currentAnimal;
        for(Comment c : animal.getComments()){
            if(c.getUserId() == userID){
                animal.getComments().remove(i);
                return;
            }
            i++;
        }
    }

    public void changeComment(String newContent) {
        for(Comment c: Animal.currentAnimal.getComments()){
            if(c.getUserId() == User.currentUser.getId()){
                c.setContent(newContent);
                return;
            }
        }
    }

    public void postComment(String comment) {
        Animal currentAnimal = Animal.currentAnimal;
        User currentUser = User.currentUser;

        currentAnimal.getComments().add(new Comment(currentUser.getId(), comment));
        return;
    }
}
