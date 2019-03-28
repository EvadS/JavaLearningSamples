package hello;


public class Program {


    public static void main(String[] args)  {
        System.out.println("testSqlite, testSqlite");

        SqLiteHelper.prepareSqlite();
        SqLiteHelper.testSelectQuery();
        System.out.println("------------------------------------");
        SqLiteHelper.getAvailabelTablesForDataBase();
    }
}
