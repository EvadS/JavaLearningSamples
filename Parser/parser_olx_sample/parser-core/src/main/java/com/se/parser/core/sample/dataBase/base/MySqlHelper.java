package com.se.parser.core.sample.dataBase.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlHelper {

    public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/parserOlx?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String DB_USER = "evad";
    public static final String DB_PASSWORD = "123456";

    public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
        Connection dbConnection = null;
        Class.forName(DB_DRIVER);

        dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        return dbConnection;
    }
}
