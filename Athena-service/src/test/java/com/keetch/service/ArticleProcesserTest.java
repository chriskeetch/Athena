package com.keetch.service;

import org.junit.Test;

/**
 * Created by keetchc on 30/09/2014.
 */
public class ArticleProcesserTest {


    @Test
    public void processDataTest() {
        ArticleProcesser processer = new ArticleProcesser();
        System.out.println(processer.processFeeds());
    }
}
