import com.mysql.cj.api.mysqla.result.Resultset;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection;

    public MySQLAdsDao(Config anInstanceOfTheConfigClass) {
        try {
            DriverManager.registerDriver(new Driver());
            this.connection = DriverManager.getConnection(
                anInstanceOfTheConfigClass.getUrl(),
                anInstanceOfTheConfigClass.getUser(),
                anInstanceOfTheConfigClass.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error obtaining database connection", e);
        }
    }

    @Override
    public List<Ad> all() {
        // 1. Create a statement
        // 2. Execute the statement
        // 3. Work with the ResultSet to get a list of Ads
        try {
            Statement stmt = this.connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM ads");
            List<Ad> adsFromDatabaseResults = createAdsFromDatabaseResults(resultSet);
            return adsFromDatabaseResults;
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads from the database", e);
        }
    }

    private List<Ad> createAdsFromDatabaseResults(ResultSet rs) throws SQLException {
        List<Ad> results = new ArrayList<>();
        while(rs.next()) {
            // create an individual Ad and add it our list
            long id = rs.getLong("id");
            long userId = rs.getLong("user_id");
            String title = rs.getString("title");
            String description = rs.getString("description");

            Ad ad = new Ad();

            ad.setId(id);
            ad.setUserId(userId);
            ad.setTitle(title);
            ad.setDescription(description);

            results.add(ad);
        }
        return results;
    }

    @Override
    public Long insert(Ad ad) {
        try {
            // 1. Create a statement
            Statement stmt = connection.createStatement();
            // 2. Craft an insert query based on the properties from our ad object
            String sql = createInsertQuery(ad);
            System.out.println("Preparing to run query: " + sql);
            // 3. run the insert query
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            // 4. return the newly generated id
            ResultSet resultSet = stmt.getGeneratedKeys();
            resultSet.next();
            return resultSet.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting a new ad", e);
        }

    }

    /**
     * returns an insert query where the values in the query come from
     * the passed ad object
     */
    private String createInsertQuery(Ad ad) {
        String sql = "INSERT INTO ads(user_id, title, description) VALUES(%d, '%s', '%s')";
        return String.format(
            sql,
            ad.getUserId(),
            ad.getTitle(),
            ad.getDescription()
        );
    }
}
