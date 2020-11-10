package com.se.sample;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.async.SingleResultCallback;
import com.mongodb.client.*;
import com.mongodb.connection.ClusterSettings;
import org.apache.log4j.Logger;
import org.bson.Document;
import com.mongodb.MongoCredential;


public class Program {

    private static final Logger log = Logger.getLogger(Program.class);

    /**
     * for version 3.9
     * @throws UnknownHostException
     */
    static void testMongoDbConnect3() throws UnknownHostException{
        MongoClientURI connectionString = new MongoClientURI("mongodb://18.184.1.118:27017");
        MongoClient mongoClient = new MongoClient(connectionString);

        System.out.println("поредством testMongoDbConnect3 ");
        long startTime = System.currentTimeMillis();
        MongoDatabase db = mongoClient.getDatabase( "Examples" );
        MongoCollection collection = db.getCollection("people");
        FindIterable fi = collection.find();
        MongoCursor cursor = fi.iterator();
        // Fetching all the documents from the mongodb.

        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("программа выполнялась testMongoDbConnect3 " + timeSpent + " миллисекунд");
        getAllDocuments(collection);
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("test");

        //PropertiesConfigurator is used to configure logger from properties file
      //  PropertyConfigurator.configure("log4j.properties");

        //Log in console in and log file
        log.info("Это информационное сообщение!");
        log.error("Это сообщение ошибки");


        try {

            MytestMongoDbConnectUserPass();

            testMongoDbConnectUserPass();
         ///   testMongoDbConnect();
           // mongo();
            testMongoDbConnectUserPass5();
            testMongoDbConnect3();
            testMongoDbConnectUserPass();
            testMongoDbConnectUserPass4();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    static void MytestMongoDbConnectUserPass() throws UnknownHostException{
        // Mongodb initialization parameters.
        int port_no = 27017;
        String auth_user="root", auth_pwd = "mongodb-dev", host_name = "18.184.1.118", db_name = "Examples", db_col_name = "people", encoded_pwd = "";

        /* Imp. Note -
         * 		1.	Developers will need to encode the 'auth_user' or the 'auth_pwd' string if it contains the <code>:</code> or the <code>@</code> symbol. If not, the code will throw the <code>java.lang.IllegalArgumentException</code>.
         *		2.	If the 'auth_user' or the 'auth_pwd' string does not contain the <code>:</code> or the <code>@</code> symbol, we can skip the encoding step.
         */

        try {
            encoded_pwd = URLEncoder.encode(auth_pwd, "UTF-8");
        }
        catch (Exception ex ){
            ex.printStackTrace();
        }

        System.out.println("поредством find ");
        long startTime = System.currentTimeMillis();
        // Mongodb connection string.
        String client_url ;//= "mongodb://" + auth_user + ":" + encoded_pwd + "@" + host_name + ":" + port_no + "/" + db_name+?authMechanism=DEFAULT&authSource=db_name;

        client_url = "mongodb://root:"+auth_pwd+"@18.184.1.118:27017";

        MongoClientURI uri = new MongoClientURI(client_url);

        // Connecting to the mongodb server using the given client uri.
        MongoClient mongo_client = new MongoClient(uri);

        // Fetching the database from the mongodb.
        MongoDatabase db = mongo_client.getDatabase(db_name);

        // Fetching the collection from the mongodb.
        MongoCollection<Document> coll = db.getCollection(db_col_name);
        log.info("Fetching all documents from the collection");

        // Performing a read operation on the collection.
        FindIterable<Document> fi = coll.find();
        MongoCursor<Document> cursor = fi.iterator();
//        try {
//            while(cursor.hasNext()) {
//                log.info(cursor.next().toJson());
//            }
//        } finally {
//            cursor.close();
//        }

        // Fetching all the documents from the mongodb.
        getAllDocuments(coll);

        //System.nanoTime();
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("программа выполнялась  testMongoDbConnectUserPass " + timeSpent + " миллисекунд");

    }


    /**
     * for version2
      * @throws UnknownHostException
     */
    static void testMongoDbConnect() throws UnknownHostException {
        String DB_SRV_USR  = "myadmin";
        String dbName = "Examples";
        String DB_SRV_PWD = "123456";
        String DB_URL = "localhost";
        String DB_PORT = "27017";
        String mongoClientURI = "mongodb://" + DB_SRV_USR + ":" + DB_SRV_PWD + "@" + DB_URL + ":" + DB_PORT + "/" + dbName;

        String connectionStringConn = "mongodb://localhost:27017";

        MongoClientURI connectionString = new MongoClientURI(connectionStringConn);

        MongoClient mongoClient = new MongoClient(connectionString);

        List<Integer> books = Arrays.asList(27464, 747854);

        String secs = String.format("%.3f",  System.currentTimeMillis() / 1000.0);
        DBObject person = new BasicDBObject("_id", secs)
                .append("name", "Jo Bloggs")
                .append("address", new BasicDBObject("street", "123 Fake St")
                        .append("city", "Faketon")
                        .append("state", "MA")
                        .append("zip", 12345))
                .append("books", books);


        DB database = mongoClient.getDB("Examples");
        DBCollection collection = database.getCollection("people");

        collection.insert(person);

        secs = String.format("%.3f",  System.currentTimeMillis() / 1000.0);
        Address adreess = new Address("Street name","city name", "102","London");
        Person myPerson = new Person(secs,"person name",adreess, "00000");
        collection.insert(PersonAdaptor.toDBObject(myPerson));

        // get
        DBObject query = new BasicDBObject("_id", "jo");
        DBCursor cursor = collection.find(query);


        cursor = collection.find();

        while(cursor.hasNext()){
            String _id =  (String)cursor.next().get("_id");
            System.out.println(String.format("%s  : %s", "id" ,_id));
        }

        //all document
        DBCursor results = collection.find(new BasicDBObject("town", "town"));
        int size = results.size();
        System.out.println(String.format("---  %s  : %s", "id" ,size));

        for (DBObject result : results) {
            System.out.println(String.format("---  %s  : %s", result.get("id") ,result.get("town")));
        }

        DBCursor results2 = collection.find(new BasicDBObject("name", "SomeName"),
                new BasicDBObject("name", 1));

        collection.remove(new BasicDBObject("_id", "jo"));
        collection.remove(new BasicDBObject("address.city", "London"));
    }



    /// юзаем это
    static void testMongoDbConnectUserPass() throws UnknownHostException{
        // Mongodb initialization parameters.
        int port_no = 27017;
        String auth_user="jcg", auth_pwd = "admin@123", host_name = "localhost", db_name = "mongoauthdemo", db_col_name = "emp", encoded_pwd = "";

        /* Imp. Note -
         * 		1.	Developers will need to encode the 'auth_user' or the 'auth_pwd' string if it contains the <code>:</code> or the <code>@</code> symbol. If not, the code will throw the <code>java.lang.IllegalArgumentException</code>.
         *		2.	If the 'auth_user' or the 'auth_pwd' string does not contain the <code>:</code> or the <code>@</code> symbol, we can skip the encoding step.
         */
        try {
            encoded_pwd = URLEncoder.encode(auth_pwd, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            log.error(ex);
        }

        System.out.println("поредством find ");
        long startTime = System.currentTimeMillis();
        // Mongodb connection string.
        String client_url = "mongodb://" + auth_user + ":" + encoded_pwd + "@" + host_name + ":" + port_no + "/" + db_name;
        MongoClientURI uri = new MongoClientURI(client_url);

        // Connecting to the mongodb server using the given client uri.
        MongoClient mongo_client = new MongoClient(uri);

        // Fetching the database from the mongodb.
        MongoDatabase db = mongo_client.getDatabase(db_name);

        // Fetching the collection from the mongodb.
        MongoCollection<Document> coll = db.getCollection(db_col_name);
        log.info("Fetching all documents from the collection");

        // Performing a read operation on the collection.
        FindIterable<Document> fi = coll.find();
        MongoCursor<Document> cursor = fi.iterator();
//        try {
//            while(cursor.hasNext()) {
//                log.info(cursor.next().toJson());
//            }
//        } finally {
//            cursor.close();
//        }

        // Fetching all the documents from the mongodb.
        getAllDocuments(coll);

        //System.nanoTime();
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("программа выполнялась  testMongoDbConnectUserPass " + timeSpent + " миллисекунд");

    }

    static void testMongoDbConnectUserPass4() throws UnknownHostException{
        // Mongodb initialization parameters.
        int port_no = 27017;
        String auth_user="jcg", auth_pwd = "admin@123", host_name = "localhost", db_name = "mongoauthdemo", db_col_name = "emp", encoded_pwd = "";

        /* Imp. Note -
         * 		1.	Developers will need to encode the 'auth_user' or the 'auth_pwd' string if it contains the <code>:</code> or the <code>@</code> symbol. If not, the code will throw the <code>java.lang.IllegalArgumentException</code>.
         *		2.	If the 'auth_user' or the 'auth_pwd' string does not contain the <code>:</code> or the <code>@</code> symbol, we can skip the encoding step.
         */
        try {
            encoded_pwd = URLEncoder.encode(auth_pwd, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            log.error(ex);
        }

        System.out.println("поредством find ");
        long startTime = System.currentTimeMillis();
        // Mongodb connection string.
        String client_url = "mongodb://" + auth_user + ":" + encoded_pwd + "@" + host_name + ":" + port_no + "/" + db_name;
        MongoClientURI uri = new MongoClientURI(client_url);

        // Connecting to the mongodb server using the given client uri.
        MongoClient mongo_client = new MongoClient(uri);

        // Fetching the database from the mongodb.
        MongoDatabase db = mongo_client.getDatabase(db_name);

        // Fetching the collection from the mongodb.
        MongoCollection<Document> coll = db.getCollection(db_col_name);
        log.info("Fetching all documents from the collection");


        // Fetching all the documents from the mongodb.

        getAllDocuments(coll);
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("программа выполнялась testMongoDbConnectUserPass4 " + timeSpent + " миллисекунд");



    }

    /**
     *
     * @throws UnknownHostException
     */
    static void testMongoDbConnectUserPass5() throws UnknownHostException{

        MongoClient client = new MongoClient(
                new ServerAddress("localhost", 27017));

    }


    // Fetching all documents from the mongo collection.

    private static void getAllDocuments(MongoCollection<Document> col) {
        System.out.println("--------------------");
        log.info("Fetching all documents from the collection");
        // Performing a read operation on the collection.
        FindIterable<Document> fi = col.find();
        MongoCursor<Document> cursor = fi.iterator();
        try {
            while(cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
               // log.info(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
    }
}
