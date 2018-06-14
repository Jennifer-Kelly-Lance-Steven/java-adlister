package com.codeup.adlister.dao;

import com.codeup.adlister.models.SearchAd;

import java.util.List;

public interface Search {
    List<SearchAd> findBySearch (String searchTerm);
}
