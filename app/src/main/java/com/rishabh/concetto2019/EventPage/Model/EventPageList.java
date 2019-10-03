package com.rishabh.concetto2019.EventPage.Model;

public class EventPageList {
    String event_name, rule_book_url, about_url;
    String organizer_name1, organizer_name2;
    String organizer_phone1, organizer_phone2;
    String prize;
    String register_url;
    String organisedBy;
    String url;


    public EventPageList(String event_name, String rule_book_url, String about_url, String organizer_name1, String organizer_name2, String organizer_phone1, String organizer_phone2, String prize, String register_url, String organisedBy, String url) {
        this.event_name = event_name;
        this.rule_book_url = rule_book_url;
        this.about_url = about_url;
        this.organizer_name1 = organizer_name1;
        this.organizer_name2 = organizer_name2;
        this.organizer_phone1 = organizer_phone1;
        this.organizer_phone2 = organizer_phone2;
        this.prize = prize;
        this.register_url = register_url;
        this.organisedBy = organisedBy;
        this.url = url;
    }
    public String getUrl() { return url; }
    public String getEvent_name() {
        return event_name;
    }

    public String getRule_book_url() {
        return rule_book_url;
    }

    public String getAbout_url() {
        return about_url;
    }

    public String getOrganizer_name1() {
        return organizer_name1;
    }

    public String getOrganizer_name2() {
        return organizer_name2;
    }

    public String getOrganizer_phone1() {
        return organizer_phone1;
    }

    public String getOrganizer_phone2() {
        return organizer_phone2;
    }

    public String getPrize() {
        return prize;
    }

    public String getRegister_url() {
        return register_url;
    }

    public String getOrganisedBy() {
        return organisedBy;
    }
}
