package lesson_29;


import lombok.AllArgsConstructor;

import java.sql.*;


public class DatabaseConnector {

    private final String URL = "jdbc:postgresql://localhost:5432/company";
    private final String USERNAME = "dmitrijn";
    private final String PASSWORD = "password";

    private Connection connection;



    public Connection getConnection() {
        return connection;
    }

    public void connection() throws ClassNotFoundException, SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

    }

    public void executeUpdateEmployee(String sql) throws SQLException {

        try (Statement statement = connection.createStatement()) {

            int rows = statement.executeUpdate(sql);
            System.out.println("Your query successful! Inserted rows: " + rows);
        }


    }

    public void disconnect() throws SQLException {
        connection.close();
        System.out.println("Connection closed");
    }

}









