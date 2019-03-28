package com.se.sample;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static final String userName = "";
    public static final String userPass = "";
    public static final String host = "";


    public static void main( String[] args )
    {
        CassandraJdbcHelper helper = new CassandraJdbcHelper();
        try {
            helper.getConnection("","");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println( "Hello World!" );
    }
}
