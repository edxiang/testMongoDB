package org.kevin.Main;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin.Z on 2018/8/9.
 */
public class Main {
    public static void main(String[] args) {
        try {
            MongoClientURI uri = new MongoClientURI("mongodb://kevin:z@localhost:27017/?authSource=test1");
            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase mongoDatabase = mongoClient.getDatabase("test1");
            System.out.println(mongoDatabase.getName());

            // create collection
            /*mongoDatabase.createCollection("collection1");*/

            // get collection
            MongoCollection<Document> collections = mongoDatabase.getCollection("collection1");
            System.out.println("get collections");

            // insert collections
            /*Document document = new Document("title", "MongoDB").append("description", "NoSQL").append("likes", 100).append("by", "kevin");
            List<Document> documents = new ArrayList<Document>();
            documents.add(document);
            collections.insertMany(documents);
            System.out.println("insert success");*/

            // list the documents of collection
            /*FindIterable<Document> findIterable = collections.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while(mongoCursor.hasNext()){
                System.out.println(mongoCursor.next());
            }*/

            // update document
            /*collections.updateMany(Filters.eq("likes",100), new Document("$set",new Document("likes",200)));*/

            // delete documents
            /*collections.deleteOne(Filters.eq("likes",200));
            collections.deleteMany(Filters.eq("likes",200));*/

            // query documents
            // db.collection.find(query, projection)
            FindIterable<Document> iterable = collections.find(Filters.eq("likes",200)); // the result is FindIterable
            MongoCursor<Document> cursor = iterable.iterator();
            while(cursor.hasNext()){
                System.out.println(cursor.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
