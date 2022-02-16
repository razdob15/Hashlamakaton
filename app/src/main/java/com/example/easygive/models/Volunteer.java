package com.example.easygive.models;

public class Volunteer {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    private String area;

    private String city;

    private String email;

    private String phone;

    private String points;

    private String [] preferences;

    public Volunteer(String name, String area, String city, String email, String phone, String points, String[] prefernces) {
        this.name = name;
        this.area = area;
        this.city = city;
        this.email = email;
        this.phone = phone;
        this.points = points;
        this.preferences = prefernces;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String[] getPreferences() {
        return preferences;
    }

    public void setPreferences(String[] preferences) {
        this.preferences = preferences;
    }
}
