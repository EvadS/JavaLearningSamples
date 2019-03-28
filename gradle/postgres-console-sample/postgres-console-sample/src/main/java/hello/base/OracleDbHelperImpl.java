package hello.base;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleDbHelperImpl implements OracleXEDbHelper {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    @Override
    public Connection getConnection(String dbDriver, String userName, String pass, String url) throws ClassNotFoundException, SQLException {
        Class.forName(dbDriver);
        Connection dbConnection = DriverManager.getConnection(url, userName, pass);
        return dbConnection;
    }

    //   jdbc:sqlserver://safechain-mssql-dev.cdwtzlzy3uua.eu-central-1.rds.amazonaws.com;database=safechain-mssql-dev


    public void getConnectionMS() throws ClassNotFoundException, SQLException {
        Statement statement = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        // Setup the connection with the DB
        String url = "jdbc:sqlserver://safechain-mssql-dev.cdwtzlzy3uua.eu-central-1.rds.amazonaws.com;database=safechain-mssql-dev";
        String userName = "safechain_mssql_user";
        String pass = "safechain-mssql-user";
        Connection dbConnection = DriverManager.getConnection(url, userName, pass);

        statement = dbConnection.createStatement();
        ResultSet re = statement.executeQuery("select * from booksOut");

        dbConnection.close();
    }

    @Override
    public void testCreateTable(Connection connection) throws SQLException {

        Statement stmt = connection.createStatement();
        // create table
        String createTable = "create table books (" +
                "  id     int," +
                "  title  varchar(50)," +
                "  author varchar(50)," +
                "  price  float," +
                "  qty    int" +
                ")";

        String setPk = "ALTER TABLE books ADD (CONSTRAINT books_pk PRIMARY KEY (id)  )";

        // create triger
        String sequence = "CREATE SEQUENCE books_sequence";

        // create sequence
        String createTrigger = "CREATE TRIGGER books_on_insert  BEFORE INSERT ON books FOR EACH ROW BEGIN SELECT books_sequence.nextval INTO :new.id FROM dual; END;";

        stmt.executeUpdate(createTable);
        System.out.println(" createTable");
        stmt.executeUpdate(setPk);
        System.out.println("setPk ");

        stmt.executeUpdate(sequence);
        System.out.println("sequrence ");
        stmt.executeUpdate(createTrigger);
        System.out.println("createTrigger ");
        System.out.println("Created table in given database...");
    }

    @Override
    public void testInserToTable() {

    }

    @Override
    public boolean isTableExist(Connection connection, String tableName) throws SQLException {
        boolean result = false;
        Statement statement = null;
        String query = "";
        ResultSet res = null;
        try {
            DatabaseMetaData meta = connection.getMetaData();
            meta.getTables(null, null, tableName, new String[]{"TABLE"});
            while (res.next()) {
                System.out.println(
                        "   " + res.getString("TABLE_CAT")
                                + ",TABLE_SCHEM " + res.getString("TABLE_SCHEM")
                                + ",TABLE_NAME " + res.getString("TABLE_NAME")
                                + ",TABLE_TYPE " + res.getString("TABLE_TYPE")
                                + ",REMARKS " + res.getString("REMARKS"));
                result = true;

            }
        } finally {
            if (res != null) {
                try {
                    res.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public boolean tableExist(Connection conn, String tableName) throws SQLException {
        boolean tExists = false;
        try (ResultSet rs = conn.getMetaData().getTables(null, null, tableName, null)) {
            while (rs.next()) {
                String tName = rs.getString(tableName);
                if (tName != null && tName.equals(tableName)) {
                    tExists = true;
                    break;
                }
            }
        }
        return tExists;
    }

    @Override
    public List<String> getTableList(Connection connection) throws SQLException {
        DatabaseMetaData md = connection.getMetaData();
        try (ResultSet rs = md.getTables(null, null, "%", null)) {
            while (rs.next()) {
                System.out.println(rs.getString(3));
            }
        }
        return new ArrayList<>();
    }

    @Override
    public List<String> getUsersTableList(Connection connection) throws SQLException {

        ArrayList<String> listofTable = new ArrayList<String>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("select object_name from user_objects where object_type = 'TABLE'");

            while (rs.next()) {
                String tableName = rs.getString(1);
                System.out.println("tableName=" + tableName);
                listofTable.add(tableName);
            }
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return listofTable;
    }


    @Override
    public void select(Connection connection) throws SQLException {
        Statement statement = null;
        String query = "select ID, TITLE,AUTHOR,PRICE,QTY from SA.BOOKS";
        ResultSet rs = null;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("ID");
                String title = rs.getString("TITLE");
                String author = rs.getString("AUTHOR");
                float price = rs.getFloat("PRICE");
                int qty = rs.getInt("QTY");

                String book = String.format("%s %s %s %s %s", id, title, author, price, qty);
                System.out.println(book);
            }
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void selectWHERE(Connection connection) throws SQLException {
        //2.PreparedStatement: предварительно компилирует запросы,
        //которые могут содержать входные параметры
        PreparedStatement preparedStatement = null;
        String query = "select ID, TITLE,AUTHOR,PRICE,QTY from books WHERE QTY >?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, 1);
        // execute select SQL stetement
        ResultSet rs = preparedStatement.executeQuery();


        while (rs.next()) {
            int id = rs.getInt("ID");
            String title = rs.getString("TITLE");
            String author = rs.getString("AUTHOR");
            float price = rs.getFloat("PRICE");
            int qty = rs.getInt("QTY");

            String book = String.format("%s %s %s %s %s", id, title, author, price, qty);
            System.out.println(book);
        }

        preparedStatement.close();
    }

    @Override
    public void insert(Connection connection, int rowNumber) throws SQLException {
        int generatedKey = -1;
        PreparedStatement statement = null;
        String insertTableSQL = "insert into SA.BOOKS (title,author,price,qty) values (?, ?, ?, ?)";

        // TODO: maybe must be on input parameters
        int qty = 10;
        String title = "title";
        String author = "author";
        float price = 11.0f;

        try {
          ///  statement = connection.prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS);  // ->AAAE9HAABAAALDZAAC
            statement = connection.prepareStatement(insertTableSQL, new String[]{"ID"});
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setFloat(3, price);
            statement.setInt(4, qty);

            // execute insert SQL stetement
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if(rs.next()) {
             // first - >
                //   java.sql.RowId rid=rs.getRowId(1);
                //what you get is only a RowId ref, try make use of it anyway U could think of

               int rid  = rs.getInt(1);
                System.out.println("Last is : " + rid);
            }

            // TODO: move to finally

        }
        finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(Connection connection, int id) throws SQLException {
        PreparedStatement statement = null;
        String updateTableSQL = "UPDATE SA.BOOKS"
                + " SET TITLE = 'NEW TITLE' "
                + " WHERE ID = ?";

        try {
            statement = connection.prepareStatement(updateTableSQL);
            statement.setInt(1, id);

            System.out.println(updateTableSQL);
            // execute update SQL stetement
            statement.execute();
            System.out.println("Record is updated to DBUSER table!");
        }
        finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void delete(Connection connection,int id) throws SQLException {
        PreparedStatement statement = null;
        String deleteSQL = "DELETE SA.BOOKS WHERE ID = ?";

        try {
            statement = connection.prepareStatement(deleteSQL);
            statement.setInt(1, id);

            // execute update SQL stetement
            statement.execute();
            System.out.println("Record is updated to DBUSER table!");
        }
        finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
