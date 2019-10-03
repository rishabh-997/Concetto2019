package com.rishabh.concetto2019.Contactus;

public class TechTeamModel {

    private String name;
    private String position;
    private int imgResource;

    public TechTeamModel(String name, String position, int imgResource) {
        this.name = name;
        this.position = position;
        this.imgResource = imgResource;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getImgResource() {
        return imgResource;
    }
}
