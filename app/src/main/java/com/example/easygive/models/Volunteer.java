package com.example.easygive.models;

import java.util.ArrayList;

public class Volunteer {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private String id;

    private String area;

    private String city;

    private String email;

    private String phone;

    private Integer points;

    private ArrayList<String> preferences;

    public Volunteer(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public ArrayList<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(ArrayList preferences) {
        this.preferences = preferences;
    }
}
