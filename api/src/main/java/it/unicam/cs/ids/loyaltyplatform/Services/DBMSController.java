package it.unicam.cs.ids.loyaltyplatform.Services;

import java.sql.*;

public class DBMSController {

    //connessione al database
    private static final String url = "jdbc:postgresql://localhost:5432/LoyaltyPlatform";
    private static final String username = "postgres";
    private static final String password = "PostgresIds";
    private static Connection conn;

    public static void init(){
        try(Connection connection = DriverManager.getConnection(url, username, password)){
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connesso!");
        } catch (SQLException e){
            throw  new IllegalStateException("Non connesso", e);
        }
    }

    public static void insertQuery(String query) throws SQLException {
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
    }

    public static void removeQuery(String query) throws SQLException {
        PreparedStatement prepareStatement = conn.prepareStatement(query);
        prepareStatement.executeUpdate();
    }
}
