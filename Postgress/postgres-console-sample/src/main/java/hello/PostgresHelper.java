package hello;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Properties;

public class PostgresHelper {

    public final static String USERNAME = "postgres";
    public final static String PASSWORD = "123456";
    public final static String DBNAME = "myDb";


     public static void getAvailabelTablesForDataBase(){


         Logger.getLogger("Program").info("Test Select Query ");

         //----------------------
         int CustID = 1;
         Connection conn = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;

         try {
             Class.forName("org.postgresql.Driver");

             String url = "jdbc:postgresql://localhost:5432/"+DBNAME;
             Properties props = new Properties();
             props.setProperty("user", USERNAME);
             props.setProperty("password", PASSWORD);

             conn = DriverManager.getConnection(url, props);
             System.out.println(conn);
             System.out.println("Opened database successfully");

             String query = "SELECT * FROM pg_catalog.pg_tables WHERE schemaname != 'pg_catalog' AND schemaname != 'information_schema'";
             pstmt = conn.prepareStatement(query);
           //  pstmt.setInt(1, CustID);

             rs = pstmt.executeQuery();

             while (rs.next()) {
                 // Make it a String to begin with.
                 String tablename = rs.getString("tablename");
                 String schemaname = rs.getString("schemaname");


                 System.out.println(String.format("%s , %s", tablename, schemaname));
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
    /**
     * более корректный вариант это выбрасывать все исключения наверх
     */
    public static void testSelectQuery(){
        Logger.getLogger("Program").info("Test Select Query ");

        //----------------------
        int CustID = 1;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/"+DBNAME;
            Properties props = new Properties();
            props.setProperty("user", USERNAME);
            props.setProperty("password", PASSWORD);

            conn = DriverManager.getConnection(url, props);
            System.out.println(conn);
            System.out.println("Opened database successfully");

            String query = "SELECT * FROM public.company WHERE id >= ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, CustID);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                // Make it a String to begin with.
                String id = rs.getString("id");
                String name = rs.getString("name");
                String address = rs.getString("address");

                System.out.println(String.format("%s , %s %s", id, name,address));
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

    private static java.sql.Timestamp getCurrentTimeStamp() {

        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());

    }

    public static void insertQuery(int count ) {
        Logger.getLogger("Program").info("Test insert Query ");


        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/" + DBNAME;
            Properties props = new Properties();
            props.setProperty("user", USERNAME);
            props.setProperty("password", PASSWORD);

            conn = DriverManager.getConnection(url, props);
            System.out.println(conn);
            System.out.println("Opened database successfully");


            String insertTableSQL = "INSERT INTO public.company( name, age, address, salary)	VALUES ( ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertTableSQL);

            System.out.println(" -->  before run insert query ");
            long startTime = System.currentTimeMillis();

            for(int i = 0 ; i< count ; i++) {

                //  pstmt.setInt(1, 11);
                pstmt.setString(1, "JSESSIO");
                pstmt.setInt(2, 60);
                pstmt.setString(3, "SafeXain");
                pstmt.setInt(4, 10000);

                // execute insert SQL stetement
                pstmt.executeUpdate();

                if(i%100 == 0 )
                    System.out.print(".");

            }

            System.out.println(" -->  after run insert query ");
            long timeSpent = System.currentTimeMillis() - startTime;
            System.out.println("программа insertQuery выполнялась   " + timeSpent + " миллисекунд");

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
