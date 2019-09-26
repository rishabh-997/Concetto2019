package com.rishabh.concetto2019.EventPage.Model;

public class EventImageModel {

    private String name;
    private int imageSource;

    public EventImageModel (int imageSource, String name) {
        this.name = name;
        this.imageSource = imageSource;
    }

    public String getName() {
        return name;
    }

    public int getImageSource() {
        return imageSource;
    }
}
