package com.database;
import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBWorker {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "3152Comr1777";
    private static final String URL = "jdbc:mysql://localhost:3306/rip"+
            "?verifyServerCertificate=false"+
            "&useSSL=false"+
            "&requireSSL=false"+
            "&useLegacyDatetimeCode=false"+
            "&amp"+
            "&serverTimezone=UTC";

    private Connection connection;

    public DBWorker(){
        try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
