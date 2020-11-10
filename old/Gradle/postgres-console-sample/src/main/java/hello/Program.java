package hello;

import net.petrikainulainen.gradle.MessageService;

import java.sql.*;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Program {

    public static void  sqlLiteCrud()   {
        Connection conn = null;
        try {
        String driver = "org.sqlite.JDBC";
        Class.forName(driver);
        String dbName = "cp2.db";
        String dbUrl = "jdbc:sqlite:" + dbName;
        DriverManager.getConnection(dbUrl);
        //create table
            conn = DriverManager.getConnection(dbUrl);

        Statement st = conn.createStatement();
         int i = st.executeUpdate("CREATE TABLE IF NOT EXISTS village (id int, name varchar(20))");
        //insert row
        st.executeUpdate("INSERT INTO village VALUES (111, 'Concretepage')");
            st.executeUpdate("INSERT INTO village VALUES (112, 'Concretepage2')");
            st.executeUpdate("INSERT INTO village VALUES (113, 'Concretepage3')");
        //select
        String query = "SELECT id, name from village";
        ResultSet rs = null;

            rs = st.executeQuery(query);
            while(rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                System.out.println("id:"+ id+ ", name: "+ name);
            }
            //delete
            st.executeUpdate("DELETE from village");
        } catch (SQLException e) {
            System.out.println("Can't get connection. Incorrect URL");
            e.printStackTrace();
            return;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Can't close connection");
            e.printStackTrace();
            return;
        }
    }

    public static void testSqlite() {
        final String driverName = "org.sqlite.JDBC";
        final String connectionString = "jdbc:sqlite:sample.db";

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.out.println("Can't get class. No driver found");
            e.printStackTrace();
            return;
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            System.out.println("Can't get connection. Incorrect URL");
            e.printStackTrace();
            return;
        }
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Can't close connection");
            e.printStackTrace();
            return;
        }
    }

    public static void testPostgreSql(){
        MessageService messageService = new MessageService();

        String message = messageService.getMessage();
        Logger.getLogger("Program").info("Received message: " + message);

        //----------------------
        int CustID = 1;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/books";
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "31323334");
            // props.setProperty("ssl", "false");

            conn = DriverManager.getConnection(url, props);
            System.out.println(conn);
            System.out.println("Opened database successfully");

            String query = "SELECT * FROM color WHERE color_id >= ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, CustID);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                // Make it a String to begin with.
                String id = rs.getString("color_id");
                String color_name = rs.getString("color_name");

                System.out.println(String.format("%s , %s ", id, color_name));

            }

            System.out.println("Hello world");
        } catch (ClassNotFoundException notFoundException) {
            int a = 10;
            System.out.println("ClassNotFoundException");
        } catch (SQLException sqlException) {
            System.out.println("SQLException, ClassNotFoundException");
            sqlException.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("SQLException, SQLException");
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.out.println("SQLException pstmt, SQLException");
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {

                    System.out.println("SQLException  conn.close(), SQLException");
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("testSqlite, testSqlite");
        testSqlite();

        System.out.println("sqlLiteCrud, sqlLiteCrud");
        sqlLiteCrud();

        //testPostgreSql();
    }
}
