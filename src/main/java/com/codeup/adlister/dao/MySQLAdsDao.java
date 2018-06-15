package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private static Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    Config.getUrl(),
                    Config.getUser(),
                    Config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    @Override
    public Ad showAd(long id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM ads WHERE id = ?");
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            return extractAd(rs);
        } catch (SQLException e) {
            throw new RuntimeException("error showing ad", e);
        }
    }

    @Override
    public List<Ad> searchAd(String searchTerm) {
        return null;
    }


    public void deleteAd(Long adID) {
        String sql = "DELETE FROM ads WHERE id = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, adID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving your ads.", e);
        }
    }

    private static Ad extractAd(ResultSet rs) throws SQLException {
       Ad ad = new Ad(
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description")

        );
        ad.setId(rs.getLong("id"));
        return ad;
    }

    public static List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    public void updateAd(String newTitle, String newDescription, Long adId){
        try {
            String insertQuery = "UPDATE ads " +
                    "SET title = ?," +
                    "description = ?" +
                    " WHERE id = ?;";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, newTitle);
            stmt.setString(2, newDescription);
            stmt.setLong(3, adId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }
}
