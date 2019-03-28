package com.se.sample;

import java.sql.*;

public class CassandraJdbcHelper {

    public void getConnection(String userName , String pass) throws SQLException, ClassNotFoundException {
        Connection con = null;
        // Establish the Connection
        StringBuilder sb_url = new StringBuilder("jdbc:cassandra://")
                .append("sa")
                .append("/")
                .append("123456")
                .append("@")
                .append("localhost")
                .append(":")
                .append(9042)
                .append("/")
                .append("cycling");
        Class.forName("org.apache.cassandra.cql.jdbc.CassandraDriver");

        con = DriverManager.getConnection(sb_url.toString());
        String query="CREATE columnfamily news(key int primary key, category text , linkcounts int ,url text)";
        Statement st = con.createStatement();




        Statement stmt = con.createStatement();
        ResultSet result = stmt.executeQuery(query);

        while (result.next()) {
            System.out.println(result.getString("KEY"));
            System.out.println(result.getString("first"));
            System.out.println(result.getString("last"));
        }
    }

}
