package com.keetch.mongo;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MongoDBUtil {

    private static Datastore datastore;

    static {
        try {
            Mongo mongo = new Mongo("localhost", 27017);
            Morphia morphia = new Morphia();
            datastore = morphia.createDatastore(mongo, "Athena");

            morphia.mapPackage("com.city81.mongodb.morphia.entity");


        } catch (UnknownHostException ex) {
            Logger.getLogger(MongoDBUtil.class.getName()).log(Level.SEVERE, null, ex);

        } catch (MongoException ex) {
            Logger.getLogger(MongoDBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Datastore getDatastore() {
        return datastore;
    }

}
