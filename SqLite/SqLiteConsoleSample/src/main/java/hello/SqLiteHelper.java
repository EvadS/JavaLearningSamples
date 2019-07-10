package hello;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Properties;

public class SqLiteHelper {

    public final static String DBNAME = "myDb25555552.db";
    public final static String DRIVERNAME = "org.sqlite.JDBC";



     public static void getAvailabelTablesForDataBase(){
         Logger.getLogger("Program").info("Test Select Query ");
         Connection conn = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;

         try {

             Class.forName(DRIVERNAME);
             String url = String.format("jdbc:sqlite:%s", DBNAME);
             Properties props = new Properties();


             conn = DriverManager.getConnection(url, props);
             System.out.println(conn);
             System.out.println("Opened database successfully");

            /* DatabaseMetaData md = conn.getMetaData();
             rs = md.getTables(null, null, "%", null);
             while (rs.next()) {
                 System.out.println(rs.getString(3));
             }


             String query = "SELECT name FROM sqlite_master";
             pstmt = conn.prepareStatement(query);

             rs = pstmt.executeQuery();

             while(rs.next()) {
                 String name = rs.getString(1);
                 System.out.println( "name: "+ name);
             }
*/
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
         }//finally
     }
    /**
     * более корректный вариант это выбрасывать все исключения наверх
     */

    public static void prepareSqlite() {
        Connection conn = null;
        try {
            Class.forName(DRIVERNAME);
            String dbUrl = String.format("jdbc:sqlite:%s", DBNAME);
            DriverManager.getConnection(dbUrl);
            //create table
            conn = DriverManager.getConnection(dbUrl);

            Statement st = conn.createStatement();
            int i = st.executeUpdate("CREATE TABLE IF NOT EXISTS village (id int, name varchar(20))");
            //insert row
            st.executeUpdate("INSERT INTO village VALUES (111, 'Concretepage')");
            st.executeUpdate("INSERT INTO village VALUES (112, 'Concretepage2')");
            st.executeUpdate("INSERT INTO village VALUES (113, 'Concretepage3')");

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



    public static void testSelectQuery(){
        Logger.getLogger("Program").info("Test Select Query ");

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            Class.forName(DRIVERNAME);
            String url = String.format("jdbc:sqlite:%s", DBNAME);
            Properties props = new Properties();


            conn = DriverManager.getConnection(url, props);
            System.out.println(conn);
            System.out.println("Opened database successfully");

            String query = "SELECT id, name from village";
            pstmt = conn.prepareStatement(query);

            rs = pstmt.executeQuery();

            while(rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                System.out.println("id:"+ id+ ", name: "+ name);
            }

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
        }//finally
    }
}
