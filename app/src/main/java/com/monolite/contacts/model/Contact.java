package com.monolite.contacts.model;

import java.io.Serializable;

/**
 * Created by JoséAugusto on 23/07/2016.
 */

public class Contact implements Serializable {

    public Contact(int id, String name, String twitter, String mail) {
        Id = id;
        Name = name;
        Twitter = twitter;
        Mail = mail;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTwitter() {
        return Twitter;
    }

    public void setTwitter(String twitter) {
        Twitter = twitter;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    private int Id;
    private String Name;
    private String Twitter;
    private String Mail;


    @Override
    public String toString() {
        return Name;
    }
}
