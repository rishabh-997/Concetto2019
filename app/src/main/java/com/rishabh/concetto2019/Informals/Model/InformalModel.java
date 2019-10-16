package com.rishabh.concetto2019.Informals.Model;

public class InformalModel {
    String about;
    String date;
    String time;
    String location;
    String name;
    String registration;
    String eventname;
    String url;

    public InformalModel(String about, String date, String time, String location, String name, String registration, String eventname, String url) {
        this.about = about;
        this.date = date;
        this.time = time;
        this.location = location;
        this.name = name;
        this.registration = registration;
        this.eventname = eventname;
        this.url = url;
    }

    public String getAbout() {
        return about;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getRegistration() {
        return registration;
    }

    public String getEventname() {
        return eventname;
    }

    public String getUrl() {
        return url;
    }
}
