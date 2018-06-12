package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

public class DatabaseSeeder {
    public static void main(String[] args) {
        User[] users = new User[]{new User("Goldfinger", "goldfinger@goldfinger.com", ("iamgoldfinger")),
                new User("Octopussy", "octopussy@octopussy.com", ("octopussy")),
                new User("Spectre", "spectre@spectre.com", ("spectreme")),
                new User("DrNo", "drno@drno.com", ("drnosaysyes")),
                new User("Thunderball", "thunderball@thunderball.com", ("thunderballit")),
                new User("Skyfall", "skyfall@skyfall.com", ("skyfallin"))
        };

        Users usersDao = DaoFactory.getUsersDao();
        Ads adsDao = DaoFactory.getAdsDao();

        for (User user : users) {
            usersDao.insert(user);
        }
    }


}
