package com.rishabh.concetto2019.WorkshopPage.Model;

public class WorkshopModel {

     String about;
    String date;
    String time;
    String location;
    String name;
    String registration;
    String eventname;
    String url;

    public WorkshopModel(String about, String date, String time, String location, String name, String registration, String eventname, String url) {
        this.about = about;
        this.date = date;
        this.time = time;
        this.location = location;
        this.name = name;
        this.registration = registration;
        this.eventname = eventname;
        this.url = url;
    }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }


    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }
}
