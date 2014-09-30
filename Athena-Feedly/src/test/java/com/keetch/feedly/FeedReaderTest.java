package com.keetch.feedly;

import org.junit.Test;

public class FeedReaderTest {

    @Test
    public void readFeedTest() {
        FeedReader feedReader = new FeedReader();
        feedReader.read("http://blog.8thlight.com/feed/atom.xml");
    }
}
