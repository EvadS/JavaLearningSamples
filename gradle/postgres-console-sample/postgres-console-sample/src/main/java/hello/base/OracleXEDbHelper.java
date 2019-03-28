package hello.base;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface OracleXEDbHelper {
//jdbc:oracle:thin:@localhost:1521:XE

    Connection getConnection(String dbDriver,String userName, String pass, String url) throws ClassNotFoundException, SQLException;

    boolean isTableExist(Connection connection,String tableName) throws SQLException;
    public boolean tableExist(Connection conn, String tableName) throws SQLException;

    void  testCreateTable(Connection connection) throws SQLException;
    void testInserToTable();

    List<String> getTableList(Connection connection) throws SQLException;
    List<String> getUsersTableList(Connection connection) throws SQLException;

    void select(Connection connection) throws SQLException;
    void selectWHERE(Connection connection) throws SQLException;


    void insert(Connection connection,int rowNumber) throws SQLException;
    void update(Connection connection,int id) throws SQLException;
    void delete(Connection connection,int id) throws SQLException;

}
