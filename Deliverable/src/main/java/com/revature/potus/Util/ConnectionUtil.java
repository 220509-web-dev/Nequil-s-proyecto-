package com.revature.potus.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil{


    public static Connection getConnection(){ // constructor to allow the class to connect to DB

       try {
        //jdbc:postgresql://host/dname?user=username&password=userpassword
        String dbInfo = "jdbc:postgresql://localhost:5432/postgres?user=kanye&password=revature";
        Connection connection = DriverManager.getConnection(dbInfo);
        return connection;
    } catch (
    SQLException e) {
        throw new RuntimeException(e);

    }

}

}
