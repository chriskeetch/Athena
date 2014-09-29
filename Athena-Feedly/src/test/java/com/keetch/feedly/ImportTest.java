package com.keetch.feedly;

import com.keetch.feedly.model.Outline;
import com.keetch.mongo.dao.FeedDAO;
import com.keetch.mongo.model.Feed;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by keetchc on 29/09/2014.
 */
public class ImportTest {

    private OMPLImporter omplImport;
    private List<Outline> feeds;
    private FeedDAO feedDao;


    @Before
    public void init() {
        omplImport = new OMPLImporter();
        feeds = omplImport.readConfig("feedly.opml");
        feedDao = new FeedDAO();
    }

    @Test
    public void ImportTest() {
        for (Outline o : feeds) {
            feedDao.addFeed(new Feed(o.getText(), o.getXmlURL(), ""));
            System.out.println(o);
        }
    }
}
