package com.rishabh.concetto2019.TechTalkPage.MVP;

public class TechtalkModel {

    String aboutSpeaker,date,field,location,time,about;

    public TechtalkModel(String aboutSpeaker, String date, String field, String location, String time, String about) {
        this.aboutSpeaker = aboutSpeaker;
        this.date = date;
        this.field = field;
        this.location = location;
        this.time = time;
        this.about = about;
    }

    public String getAboutSpeaker() {
        return aboutSpeaker;
    }

    public void setAboutSpeaker(String aboutSpeaker) {
        this.aboutSpeaker = aboutSpeaker;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
