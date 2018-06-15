package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    Ad showAd(long id);
    List<Ad> searchAd(String searchTerm);
    public void updateAd(String oldTitle, String oldDescription, Long adId);
    public void deleteAd(Long adID);

}
