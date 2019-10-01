package com.rishabh.concetto2019.Developers.Model;

public class Developers
{
    String name;
    String github;
    String linkedIn;
    String branch;
    int id;

    public Developers(String name, String github, String linkedIn, String branch, int id) {
        this.name = name;
        this.github = github;
        this.linkedIn = linkedIn;
        this.branch = branch;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getGithub() {
        return github;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public String getBranch() {
        return branch;
    }

    public int getId() {
        return id;
    }
}
