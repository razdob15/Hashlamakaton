package com.example.easygive.models;

import java.util.Date;

public class Mission {
    private int serialNum;
    private String name;
    private String date;
    private String description;
    private String area;
    private String city;
    private boolean carNeeded;
    private String organizer;
    private int peopleNeeded;
//    public Mission(int num, String name, String date, String description, String area, String city, boolean carNeeded, String organizer, int peopleNeeded) {
//        this.serialNum = num;
//        this.name = name;
//        this.date = date;
//        this.city = city;
//
//    }


    public Mission(int serialNum, String name, String date, String description, String area, String city, boolean carNeeded, String organizer, int peopleNeeded) {
        this.serialNum = serialNum;
        this.name = name;
        this.date = date;
        this.description = description;
        this.area = area;
        this.city = city;
        this.carNeeded = carNeeded;
        this.organizer = organizer;
        this.peopleNeeded = peopleNeeded;
    }

    public int getNum() {
        return serialNum;
    }
    public void setNum(int num) {
        this.serialNum = num;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public boolean isCarNeeded() {
        return carNeeded;
    }

    public void setCarNeeded(boolean carNeeded) {
        this.carNeeded = carNeeded;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public int getPeopleNeeded() {
        return peopleNeeded;
    }

    public void setPeopleNeeded(int peopleNeeded) {
        this.peopleNeeded = peopleNeeded;
    }
}
