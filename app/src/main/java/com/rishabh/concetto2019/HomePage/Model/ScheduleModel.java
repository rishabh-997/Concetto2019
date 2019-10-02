package com.rishabh.concetto2019.HomePage.Model;

public class ScheduleModel
{
    String name, time, location;

    public ScheduleModel(String name, String time, String location) {
        this.name = name;
        this.time = time;
        this.location = location;
    }


    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }
}
