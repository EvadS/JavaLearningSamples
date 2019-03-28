package hello;

import hello.base.OracleDbHelperImpl;

import java.sql.*;
import java.util.List;
import java.util.Properties;

public class Program {

    private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "123456";


    public static void main(String[] args) throws SQLException {
        OracleDbHelperImpl helperImpl = new OracleDbHelperImpl();

        Connection conn = null;
        try {

            conn = helperImpl.getConnection(DB_DRIVER, DB_USER, DB_PASSWORD, DB_CONNECTION);
/*
            if (!helperImpl.isTableExist(conn, "BOOKS")) {
                helperImpl.testCreateTable(conn);
            }

            helperImpl.tableExist(conn, "conn");

            List<String> tablesList = helperImpl.getUsersTableList(conn);

*/
//            helperImpl.selectWHERE(conn);
             helperImpl.insert(conn,10);

        //     helperImpl.update(conn,28);
        //     helperImpl.delete(conn,31);


            int a = 10;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }






    public static void testOracleDB() {

        Statement pstmt = null;
        ResultSet rs = null;

        ResultSet resultSetObj;
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");


            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            Properties props = new Properties();
            props.setProperty("user", "sa");
            props.setProperty("password", "123456");
            // props.setProperty("ssl", "false");

            conn = DriverManager.getConnection(url, props);

            //  conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sa", "123456");

            if (conn != null) {
                System.out.println("!! Connected With Oracle Database !!\n");
            }

            pstmt = conn.createStatement();

            // Step 4 - Execute SQL Query
            String query = "select * from employee";
            resultSetObj = pstmt.executeQuery(query);

            while (resultSetObj.next()) {
                // Make it a String to begin with.
                String id = resultSetObj.getString("emp_id");
                String title = resultSetObj.getString("emp_name");

                System.out.println(String.format("%s , %s ", id, title));

            }

        } catch (ClassNotFoundException notFoundException) {
            int a = 10;
            System.out.println("ClassNotFoundException");
        } catch (SQLException sqlException) {
            System.out.println("SQLException");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
