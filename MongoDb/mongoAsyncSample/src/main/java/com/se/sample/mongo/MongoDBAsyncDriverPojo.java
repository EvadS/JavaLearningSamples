package com.se.sample.mongo;


import com.mongodb.Block;
import com.mongodb.async.SingleResultCallback;
import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClients;
import com.mongodb.async.client.MongoCollection;
import com.mongodb.async.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;


import java.util.List;
import java.util.concurrent.CountDownLatch;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.not;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import static java.util.Arrays.asList;

public class MongoDBAsyncDriverPojo {


    public void run() throws InterruptedException {

        MongoClient mongoClient;
        // connect to the local database server
        mongoClient = MongoClients.create();



        // get handle to "mydb" database
        MongoDatabase database = mongoClient.getDatabase("mydb");

        // get a handle to the "people" collection
        final MongoCollection<Person> collection = database.getCollection("people", Person.class);

        // drop all the data in it
        final CountDownLatch dropLatch = new CountDownLatch(1);
        collection.drop(new SingleResultCallback<Void>() {
            @Override
            public void onResult(final Void result, final Throwable t) {
                dropLatch.countDown();
            }
        });
        dropLatch.await();

        // make a document and insert it
        Person ada = new Person("Ada Byron", 20, new Address("St James Square", "London", "W1"));
        collection.insertOne(ada, new SingleResultCallback<Void>() {
            @Override
            public void onResult(final Void result, final Throwable t) {
                System.out.println("Inserted!");
            }
        });

        // get it (since it's the only one in there since we dropped the rest earlier on)
        SingleResultCallback<Person> printCallback = new SingleResultCallback<Person>() {
            @Override
            public void onResult(final Person person, final Throwable t) {
                System.out.println(person);
            }
        };
        collection.find().first(printCallback);

        // now, lets add some more people so we can explore queries and cursors
        List<Person> people = asList(
                new Person("Charles Babbage", 45, new Address("5 Devonshire Street", "London", "W11")),
                new Person("Alan Turing", 28, new Address("Bletchley Hall", "Bletchley Park", "MK12")),
                new Person("Alan Turing", 28, new Address("Bletchley Hall", "Bletchley Park", "MK12")),
                new Person("Alan Turing", 28, new Address("Bletchley Hall", "Bletchley Park", "MK12")),
                new Person("Alan Turing", 28, new Address("Bletchley Hall", "Bletchley Park", "MK12")),
                new Person("Alan Turing", 28, new Address("Bletchley Hall", "Bletchley Park", "MK12")),
                new Person("Alan Turing", 28, new Address("Bletchley Hall", "Bletchley Park", "MK12")),
                new Person("Alan Turing", 28, new Address("Bletchley Hall", "Bletchley Park", "MK12")),
                new Person("Alan Turing", 28, new Address("Bletchley Hall", "Bletchley Park", "MK12")),
                new Person("Alan Turing", 28, new Address("Bletchley Hall", "Bletchley Park", "MK12")),
                new Person("Alan Turing", 28, new Address("Bletchley Hall", "Bletchley Park", "MK12")),
                new Person("Alan Turing", 28, new Address("Bletchley Hall", "Bletchley Park", "MK12")),
                new Person("Alan Turing", 28, new Address("Bletchley Hall", "Bletchley Park", "MK12")),
                new Person("Alan Turing", 28, new Address("Bletchley Hall", "Bletchley Park", "MK12")),
                new Person("Alan Turing", 28, new Address("Bletchley Hall", "Bletchley Park", "MK12")),
                new Person("Alan Turing", 28, new Address("Bletchley Hall", "Bletchley Park", "MK12")),
                new Person("Timothy Berners-Lee", 61, new Address("Colehill", "Wimborne", null))
        );

        final CountDownLatch countLatch = new CountDownLatch(1);
        collection.insertMany(people, new SingleResultCallback<Void>() {
            @Override
            public void onResult(final Void result, final Throwable t) {
                collection.countDocuments(new SingleResultCallback<Long>() {
                    @Override
                    public void onResult(final Long count, final Throwable t) {
                        System.out.println("total # of people " + count);
                        countLatch.countDown();
                    }
                });
            }
        });
        countLatch.await();

        System.out.println("");
        // lets get all the documents in the collection and print them out
        Block<Person> printBlock = new Block<Person>() {
            @Override
            public void apply(final Person person) {
                System.out.println(person);
            }
        };
        SingleResultCallback<Void> callbackWhenFinished = new SingleResultCallback<Void>() {
            @Override
            public void onResult(final Void result, final Throwable t) {
                System.out.println("Operation Finished!");
            }
        };
        collection.find().forEach(printBlock, callbackWhenFinished);

        System.out.println("");
        // now use a query to get 1 document out
        collection.find(eq("address.city", "Wimborne")).first(printCallback);

        System.out.println("");
        // now lets find every over 30
        collection.find(gt("age", 30)).forEach(printBlock, callbackWhenFinished);

        System.out.println("");
        // Update One
        SingleResultCallback<UpdateResult> printModifiedCount = new SingleResultCallback<UpdateResult>() {
            @Override
            public void onResult(final UpdateResult result, final Throwable t) {
                System.out.println(result.getModifiedCount());
            }
        };
        collection.updateOne(eq("name", "Ada Byron"), combine(set("age", 23), set("name", "Ada Lovelace")),
                printModifiedCount);

        System.out.println("");
        // Update Many
        collection.updateMany(not(eq("zip", null)), set("zip", null),
                printModifiedCount);

        System.out.println("");
        // Replace One
        collection.replaceOne(eq("name", "Ada Lovelace"), ada, printModifiedCount);

        // Delete One
        SingleResultCallback<DeleteResult> printDeletedCount = new SingleResultCallback<DeleteResult>() {
            @Override
            public void onResult(final DeleteResult result, final Throwable t) {
                System.out.println(result.getDeletedCount());
            }
        };
        collection.deleteOne(eq("address.city", "Wimborne"), printDeletedCount);

        // Delete Many
        collection.deleteMany(eq("address.city", "London"), printDeletedCount);

        // Clean up
        final CountDownLatch deleteLatch = new CountDownLatch(1);
        database.drop(new SingleResultCallback<Void>() {
            @Override
            public void onResult(final Void result, final Throwable t) {
                deleteLatch.countDown();
            }
        });
        deleteLatch.await();

        // release resources
        mongoClient.close();
    }

}
