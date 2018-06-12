package com.codeup.adlister.models;

public class Ad {
    private long id;
    private long userId;
    private long adsCatPid;
    private String title;
    private String description;

    public Ad(long userId, long adsCatPid, String title, String description) {
        this.adsCatPid = adsCatPid;
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

    public Ad(long userId, String title, String description) {
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

    public long getAdsCatPid() {
        return adsCatPid;
    }

    public void setAdsCatPid(long adsCatPid) {
        this.adsCatPid = adsCatPid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
