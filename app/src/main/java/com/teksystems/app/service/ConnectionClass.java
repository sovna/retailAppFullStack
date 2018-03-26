package com.teksystems.app.service;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 * Created by sopani on 3/24/2018.
 */

public class ConnectionClass implements Runnable {

    java.sql.Connection con = null;
    public Connection getConnections(){
        this.run();
        return con;
    }
    public void run() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            con = DriverManager.getConnection("jdbc:oracle:thin:@166.78.244.8:1521/DEMODB", "fstack", "fstack");
        } catch (Exception s) {
            System.out.println("SQL statement is not executed!");

        }
    }
}
