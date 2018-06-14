package com.codeup.adlister.dao;

import com.codeup.adlister.models.SearchAd;

public class DaoFactory {
    private static Ads adsDao;
    private static Users usersDao;
    private static Search searchAdDao;
    private static Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }

    public static Search getSearchDao() {
        if (searchAdDao == null) {
            searchAdDao = new MySQLSearchDao(config);
        }
        return searchAdDao;
    }

}
