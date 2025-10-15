package org.example;

import java.sql.*;

public class conn {

    Connection connection;
    Statement stmt,stmt1;

//    private static final String url = "jdbc:mysql://127.0.0.1:3306/bankmanagementsystem";
//    private static final String username = "root";
//    private static final String password = "Gupt9akanksha";

    public conn() {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Gupt@9akanksha");
            stmt = connection.createStatement();
//            stmt1 = connection.createStatement();


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
