package com.example.easygive.models;

public class Volunteer {
    private String area;

    private String city;

    private String email;

    private String phone;

    private String points;

    private String [] preferences;

    public Volunteer(String area, String city, String email, String phone, String points, String[] prefernces) {
        this.area = area;
        this.city = city;
        this.email = email;
        this.phone = phone;
        this.points = points;
        this.preferences = prefernces;
    }
}
