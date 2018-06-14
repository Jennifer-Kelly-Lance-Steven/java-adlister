package com.codeup.adlister.models;

public class SearchAd {
    private long userId;
    private String title;
    private String description;
    private long id;
    private String username;
    private String email;

    public SearchAd(Long userId, String title, String description, long id, String username, String email) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
