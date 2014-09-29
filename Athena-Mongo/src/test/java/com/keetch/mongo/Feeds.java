package com.keetch.mongo;

import com.keetch.mongo.model.Feed;
import com.mongodb.DBCollection;
import org.junit.Test;

/**
 * Created by chris on 29/09/2014.
 */

public class Feeds {

    @Test
    public void createFeed() {
        DBCollection feeds = MongoDBUtil.getCollection(Feed.DBCOLLECTION);

    }
}
