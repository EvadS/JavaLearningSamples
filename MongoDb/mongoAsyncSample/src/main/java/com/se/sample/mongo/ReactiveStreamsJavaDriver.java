package com.se.sample.mongo;

import com.mongodb.ConnectionString;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.model.BulkWriteOptions;
import com.mongodb.client.model.DeleteOneModel;
import com.mongodb.client.model.InsertOneModel;
import com.mongodb.client.model.ReplaceOneModel;
import com.mongodb.client.model.UpdateOneModel;
import com.mongodb.client.model.WriteModel;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;
import com.mongodb.reactivestreams.client.Success;
import org.bson.Document;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;


import static com.mongodb.client.model.Filters.and;
        import static com.mongodb.client.model.Filters.eq;
        import static com.mongodb.client.model.Filters.exists;
        import static com.mongodb.client.model.Filters.gt;
        import static com.mongodb.client.model.Filters.gte;
        import static com.mongodb.client.model.Filters.lt;
        import static com.mongodb.client.model.Filters.lte;
        import static com.mongodb.client.model.Projections.excludeId;
        import static com.mongodb.client.model.Sorts.descending;

public class ReactiveStreamsJavaDriver {
    private static final String DB_NAME = "Example";
    private static final String TABLE_NAME = "test";

    public void run() throws Throwable {
        // To directly connect to the default server localhost on port 27017
        //MongoClient mongoClient = MongoClients.create();

        // Use a Connection String
        // MongoClient mongoClient = MongoClients.create("mongodb://localhost");

        // or a Connection String
        MongoClient mongoClient = MongoClients.create(new ConnectionString("mongodb://localhost:27017"));

        // or provide custom MongoClientSettings
        //  ClusterSettings clusterSettings = ClusterSettings.builder().hosts(asList(new ServerAddress("localhost"))).build();
        //  MongoClientSettings settings = MongoClientSettings.builder().clusterSettings(clusterSettings).build();
        //  MongoClient mongoClient = MongoClients.create(settings);

        MongoDatabase database = mongoClient.getDatabase(DB_NAME);
        MongoCollection<Document> collection = database.getCollection(TABLE_NAME);


        // drop all the data in it
        SubscriberHelpers.ObservableSubscriber subscriber = new SubscriberHelpers.ObservableSubscriber<Success>();
        collection.drop().subscribe(subscriber);
        subscriber.await();

        Document doc = new Document("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("info", new Document("x", 203).append("y", 102));


        //The example below does nothing:
        Publisher<Success> publisher = collection.insertOne(doc);

        //Only when a Publisher is subscribed to and data requested will the operation happen:
        publisher.subscribe(new Subscriber<Success>() {
            @Override
            public void onSubscribe(final Subscription s) {
                s.request(1);  // <--- Data requested and the insertion will now occur
            }

            @Override
            public void onNext(final Success success) {
                System.out.println("Inserted");
            }

            @Override
            public void onError(final Throwable t) {
                System.out.println("Failed");
            }

            @Override
            public void onComplete() {
                System.out.println("Completed");
            }
        });

        collection.insertOne(doc).subscribe(new SubscriberHelpers.OperationSubscriber<Success>());


        //Add Multiple Documents
        List<Document> documents = new ArrayList<Document>();
        for (int i = 0; i < 100; i++) {
            documents.add(new Document("i", i));
        }


        subscriber = new SubscriberHelpers.ObservableSubscriber<Success>();
        collection.insertMany(documents).subscribe(subscriber);
        subscriber.await();

        collection.countDocuments()
                .subscribe(new SubscriberHelpers.PrintSubscriber<Long>("total # of documents after inserting 100 small ones (should be 101): %s"));

        subscriber = new SubscriberHelpers.PrintDocumentSubscriber();
        collection.find().first().subscribe(subscriber);
        subscriber.await();

        subscriber = new SubscriberHelpers.PrintDocumentSubscriber();
        collection.find().subscribe(subscriber);
        subscriber.await();

        // Query Filters
        // now use a query to get 1 document out
        collection.find(eq("i", 71)).first().subscribe(new SubscriberHelpers.PrintDocumentSubscriber());

        // now use a range query to get a larger subset
        collection.find(gt("i", 50)).subscribe(new SubscriberHelpers.PrintDocumentSubscriber());

        // range query with multiple constraints
        collection.find(and(gt("i", 50), lte("i", 100))).subscribe(new SubscriberHelpers.PrintDocumentSubscriber());

        // Sorting
        collection.find(exists("i")).sort(descending("i")).first().subscribe(new SubscriberHelpers.PrintDocumentSubscriber());

        // Projection
        collection.find().projection(excludeId()).first().subscribe(new SubscriberHelpers.PrintDocumentSubscriber());

        // Update One
        collection.updateOne(eq("i", 10), new Document("$set", new Document("i", 110)))
                .subscribe(new SubscriberHelpers.PrintSubscriber<UpdateResult>("Update Result: %s"));


        // Update Many
        subscriber = new SubscriberHelpers.PrintSubscriber<UpdateResult>("Update Result: %s");
        collection.updateMany(lt("i", 100), new Document("$inc", new Document("i", 100))).subscribe(subscriber);
        subscriber.await();

        // Delete One
        collection.deleteOne(eq("i", 110)).subscribe(new SubscriberHelpers.PrintSubscriber<DeleteResult>("Delete Result: %s"));

        // Delete Many
        collection.deleteMany(gte("i", 100)).subscribe(new SubscriberHelpers.PrintSubscriber<DeleteResult>("Delete Result: %s"));

        subscriber = new SubscriberHelpers.ObservableSubscriber<Success>();
        collection.drop().subscribe(subscriber);
        subscriber.await();

        // ordered bulk writes
        List<WriteModel<Document>> writes = new ArrayList<WriteModel<Document>>();
        writes.add(new InsertOneModel<Document>(new Document("_id", 4)));
        writes.add(new InsertOneModel<Document>(new Document("_id", 5)));
        writes.add(new InsertOneModel<Document>(new Document("_id", 6)));
        writes.add(new UpdateOneModel<Document>(new Document("_id", 1), new Document("$set", new Document("x", 2))));
        writes.add(new DeleteOneModel<Document>(new Document("_id", 2)));
        writes.add(new ReplaceOneModel<Document>(new Document("_id", 3), new Document("_id", 3).append("x", 4)));

        subscriber = new SubscriberHelpers.PrintSubscriber<BulkWriteResult>("Bulk write results: %s");
        collection.bulkWrite(writes).subscribe(subscriber);
        subscriber.await();

        subscriber = new SubscriberHelpers.ObservableSubscriber<Success>();
        collection.drop().subscribe(subscriber);
        subscriber.await();

        subscriber = new SubscriberHelpers.PrintSubscriber<BulkWriteResult>("Bulk write results: %s");
        collection.bulkWrite(writes, new BulkWriteOptions().ordered(false)).subscribe(subscriber);
        subscriber.await();

        subscriber = new SubscriberHelpers.PrintDocumentSubscriber();
        collection.find().subscribe(subscriber);
        subscriber.await();

        // Clean up
        subscriber = new SubscriberHelpers.PrintSubscriber("Collection Dropped");
        collection.drop().subscribe(subscriber);
        subscriber.await();

        mongoClient.close();

    }
}
