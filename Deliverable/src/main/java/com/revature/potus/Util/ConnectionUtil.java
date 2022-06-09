package com.revature.potus.Util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil{

    private static ConnectionUtil sqlConnection;
    public static ConnectionUtil getInstance() { // constructor to allow the class to connect to DB

        if (sqlConnection == null) {
            sqlConnection = new ConnectionUtil();
        }

        return sqlConnection;
    }

    static {
        try {
            Class.forName("org.postgresql.Driver");
        }catch (Exception e) {
            System.err.println("Failed to load PostgresSQL Driver");
            throw new RuntimeException(e);
        }
    }

        private Properties props = new Properties();

    private ConnectionUtil() {
        try {
            props.load(new FileReader("src/main/resources/application.properties"));
        } catch (Exception e) {
          System.out.println("Failed to load");
         throw new RuntimeException(e);
       }
    }
        public Connection getConnection() throws SQLException {
            Connection conn = DriverManager.getConnection(props.getProperty("db-url"),
                    props.getProperty("db-username"),
                    props.getProperty("db-password"));

            if (conn == null) {
                throw new RuntimeException("could not establish a connection to the database");
            }

            return conn;

        }

}


