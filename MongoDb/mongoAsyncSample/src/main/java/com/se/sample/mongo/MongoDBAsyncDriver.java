package com.se.sample.mongo;

import com.mongodb.Block;
import com.mongodb.ConnectionString;
import com.mongodb.async.SingleResultCallback;
import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClients;
import com.mongodb.async.client.MongoCollection;
import com.mongodb.async.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;


//didn;t work
public class MongoDBAsyncDriver {

    // Print out all databases
    final CountDownLatch listDbsLatch = new CountDownLatch(1);


    public  void run() throws InterruptedException {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        MongoDatabase database = mongoClient.getDatabase("Examples");

        MongoCollection<Document> collection = database.getCollection("people2");



        System.out.println("Outputting database names:");
        mongoClient.listDatabaseNames().forEach(new Block<String>() {
            @Override
            public void apply(final String name) {
                System.out.println(" - " + name);
            }
        }, new SingleResultCallback<Void>() {
            @Override
            public void onResult(final Void result, final Throwable t) {
                listDbsLatch.countDown();
            }
        });
        boolean listedAllDbs = listDbsLatch.await(1, TimeUnit.SECONDS);
        assert(listedAllDbs);


        // Drop the collection and insert 100 documents
        final CountDownLatch insertLatch = new CountDownLatch(1);
      //  System.out.println("Dropping collection and inserting documents");


        boolean inserted = insertLatch.await(10, TimeUnit.SECONDS);
        assert(inserted);

        // Count should now be 100
        final CountDownLatch countLatch = new CountDownLatch(1);
        final AtomicLong count = new AtomicLong();
        System.out.println("Counting the number of documents");
        collection.countDocuments(new SingleResultCallback<Long>() {
            @Override
            public void onResult(final Long result, final Throwable t) {
                count.set(result);
                countLatch.countDown();
            }
        });
        boolean counted = countLatch.await(1, TimeUnit.SECONDS);
        assert(counted);
        System.out.println(" - Count result: " + count.get());




        //*****************
        Document doc = new Document("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
                .append("info", new Document("x", 203).append("y", 102));

        collection.insertOne(doc, new SingleResultCallback<Void>() {
            @Override
            public void onResult(final Void result, final Throwable t) {
                System.out.println("Inserted!");
            }
        });

        //can be implemented as a lambda if using Java 8
        collection.insertOne(doc, (Void result, final Throwable t) -> System.out.println("Inserted!"));


        List<Document> documents = new ArrayList<Document>();
        for (int i = 0; i < 1000; i++) {
            documents.add(new Document("i", i));
        }

        collection.insertMany(documents, new SingleResultCallback<Void>() {
            @Override
            public void onResult(final Void result, final Throwable t) {
                System.out.println("Documents inserted!");
            }
        });


        collection.countDocuments(
                new SingleResultCallback<Long>() {
                    @Override
                    public void onResult(final Long count, final Throwable t) {
                        System.out.println(count);
                    }
                });

        // release resources
        mongoClient.close();
    }

    /**
     * http://mongodb.github.io/mongo-java-driver/3.9/driver-async/getting-started/quick-start/
     * @throws InterruptedException
     */
    public  void run2() throws InterruptedException
    {
        MongoClient mongoClient = MongoClients.create(new ConnectionString("mongodb://localhost:27017"));

        MongoDatabase database = mongoClient.getDatabase("Example");

        MongoCollection<Document> collection = database.getCollection("people2");

        collection.countDocuments(
                new SingleResultCallback<Long>() {
                    @Override
                    public void onResult(final Long count, final Throwable t) {
                        System.out.println(count);
                    }
                });

        collection.find().first(callbackPrintDocuments);

        //Метод forEach () также принимает обратный вызов, который запускается после завершения итерации.
        collection.find().forEach(printDocumentBlock, callbackWhenFinished);

        //Delete a Single Document That Match a Filter
        collection.deleteOne(eq("i", 110), new SingleResultCallback<DeleteResult>() {
            @Override
            public void onResult(final DeleteResult result, final Throwable t) {
                System.out.println(result.getDeletedCount());
            }
        });

        collection.deleteMany(gte("i", 100), new SingleResultCallback<DeleteResult>() {
            @Override
            public void onResult(final DeleteResult result, final Throwable t) {
                System.out.println(result.getDeletedCount());
            }
        });

        mongoClient.close();


    }

    SingleResultCallback<Document> callbackPrintDocuments = new SingleResultCallback<Document>() {
        @Override
        public void onResult(final Document document, final Throwable t) {
            System.out.println(document.toJson());
        }
    };

    Block<Document> printDocumentBlock = new Block<Document>() {
        @Override
        public void apply(final Document document) {
            System.out.println(document.toJson());
        }
    };

    SingleResultCallback<Void> callbackWhenFinished = new SingleResultCallback<Void>() {
        @Override
        public void onResult(final Void result, final Throwable t) {
            System.out.println("Operation Finished!");
        }
    };
}
