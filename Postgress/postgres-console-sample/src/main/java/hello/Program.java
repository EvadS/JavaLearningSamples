package hello;


public class Program {


    public static void main(String[] args)  {
        System.out.println("testSqlite, testSqlite");
       // PostgresHelper.testSelectQuery();
        System.out.println("------------------------------------");
       // PostgresHelper.getAvailabelTablesForDataBase();

        int countStep = 1000;
        PostgresHelper.insertQuery(countStep);
    }
}
