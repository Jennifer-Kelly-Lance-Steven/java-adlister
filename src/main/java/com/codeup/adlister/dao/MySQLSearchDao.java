package com.codeup.adlister.dao;

import com.codeup.adlister.models.SearchAd;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLSearchDao implements Search {
    private static Connection connection = null;

    public MySQLSearchDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<SearchAd> findBySearch(String searchTerm) {
        try {
            String query = "select ads.user_id, ads.title, ads.description, users.id, users.username, users.email from ads " +
                    "left join users on ads.user_id = users.id " +
                    "where ads.description like ? or users.username like ? OR ads.title LIKE ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + searchTerm + "%");
            statement.setString(2, "%" + searchTerm + "%");
            statement.setString(3, "%" + searchTerm + "%");
            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();
            return createSearchList(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException("Error findBySearch", e);
        }
    }

    private List<SearchAd> createSearchList(ResultSet resultSet) throws SQLException {
        List<SearchAd> searches = new ArrayList<>();
        while (resultSet.next()) {
            searches.add(extractSearchAd(resultSet));
        }
        return searches;
    }

    private SearchAd extractSearchAd(ResultSet resultSet) throws SQLException {
        return new SearchAd(
                resultSet.getLong("user_id"),
                resultSet.getString("title"),
                resultSet.getString("description"),
                resultSet.getLong("id"),
                resultSet.getString("username"),
                resultSet.getString("email")
        );
    }
}