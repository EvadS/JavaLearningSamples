package com.se.sample.mongo;

import com.mongodb.Block;
import com.mongodb.ServerAddress;
import com.mongodb.async.SingleResultCallback;
import com.mongodb.async.client.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.connection.ClusterSettings;
import com.mongodb.ConnectionString;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.inc;
import static com.mongodb.client.model.Updates.set;
import static java.util.Arrays.asList;
import static java.lang.System.*;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        try {
//            testGoto();
//            MongoDBAsyncDriver driver = new MongoDBAsyncDriver();
//            driver.run();// abDriver = new MongoDBAsyncDriver();
//
//            System.out.println("--------------------------------------");
//            MongoDBAsyncDriverPojo dbAdriver = new MongoDBAsyncDriverPojo();
//            dbAdriver.run();

            ReactiveStreamsJavaDriver rsjDriver  = new ReactiveStreamsJavaDriver();
            rsjDriver.run();
            int b = 10;
        } catch (Exception ex) {
            int a = 10;
            ex.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        out.println("Hello World!");
    }


    static void testGoto(){

        int[][] matrix = { { 0, 1, 2 }, { 3, 4, 4 }, { 6, 4, 8 }  };
        int n  = 3;
        int m =3 ;
        int value = 4 ;

        outer: {
            for(int i=0; i<n; i++)
                for (int j=0; j<m; j++)
                    if (matrix[i][j] == value)
                    {
                        System.out.println("value " + value + " found in cell (" + i + "," + j + ")");
                        break outer;
                    }
            System.out.println("value " + value + " not found");
        }
    }


}
