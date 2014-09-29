package com.keetch.mongo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MongoDBUtil {

    private static DB database;

    static {
        try {
            MongoClient mongo = new MongoClient("localhost", 27017);
            database = mongo.getDB("Athena");
        } catch (UnknownHostException ex) {
            Logger.getLogger(MongoDBUtil.class.getName()).log(Level.SEVERE, null, ex);

        } catch (MongoException ex) {
            Logger.getLogger(MongoDBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static DBCollection getCollection(String collectionName) {
        return database.getCollection(collectionName);
    }

}
