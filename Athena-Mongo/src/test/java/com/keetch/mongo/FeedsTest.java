package com.keetch.mongo;

import com.google.code.morphia.Key;
import com.keetch.mongo.dao.ArticleDAO;
import com.keetch.mongo.dao.FeedDAO;
import com.keetch.mongo.model.Article;
import com.keetch.mongo.model.Feed;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by chris on 29/09/2014.
 */

public class FeedsTest {
    private FeedDAO feedDao;
    private ArticleDAO articleDao;

    @Before
    public void init() {
        feedDao = new FeedDAO();
        articleDao = new ArticleDAO();
    }


    @Test
    public void createFeedItemTest() {

        Feed feed = new Feed("Chris title", "http://localhost:8380", "Agile");
        Key<Feed> savedFeed = feedDao.addFeed(feed);
        assertNotNull(savedFeed);
        System.out.println(savedFeed.getId());

    }

    @Test
    public void listFeedsTest() {

        for (Feed f : feedDao.listFeeds()) {
            System.out.println(f);
            assertNotNull(f.getTitle());
            assertNotNull(f.getUrl());
        }
    }

    @Test
    public void listArticlesTest() {

        for (Article a : articleDao.listFeeds()) {
            System.out.println(a);
            assertNotNull(a.getTitle());
        }
    }

    @Test
    public void deleteAllTest() {
        feedDao.deleteAll();
        assertTrue(feedDao.listFeeds().size() == 0);
    }

    @Test
    public void deleteAllArticlesTest() {
        articleDao.deleteAll();
        assertTrue(articleDao.listFeeds().size() == 0);
    }

}
