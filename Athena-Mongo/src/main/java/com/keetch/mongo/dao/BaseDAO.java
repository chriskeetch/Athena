package com.keetch.mongo.dao;

import com.google.code.morphia.Datastore;
import com.keetch.mongo.MongoDBUtil;

/**
 * Created by keetchc on 30/09/2014.
 */
public class BaseDAO {

    private Datastore datastore;

    public BaseDAO() {
        datastore = MongoDBUtil.getDatastore();
    }

    public Datastore getDatastore() {
        return datastore;
    }

    public void setDatastore(Datastore datastore) {
        this.datastore = datastore;
    }


}
