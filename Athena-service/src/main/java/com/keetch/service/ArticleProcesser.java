package com.keetch.service;

import com.keetch.feedly.FeedReader;
import com.keetch.feedly.model.FeedArticle;
import com.keetch.feedly.model.Link;
import com.keetch.mongo.dao.ArticleDAO;
import com.keetch.mongo.dao.FeedDAO;
import com.keetch.mongo.model.Article;
import com.keetch.mongo.model.Feed;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by keetchc on 30/09/2014.
 */
public class ArticleProcesser {

    public int processFeeds() {
        int processedArticles = 0;
        FeedDAO feedDao = new FeedDAO();
        ArticleDAO articleDao = new ArticleDAO();
        FeedReader feedReader = new FeedReader();
        List<Feed> feeds = feedDao.listFeeds();
        for (Feed f : feeds) {
            List<FeedArticle> feedArticles = feedReader.read(f.getUrl());
            for (FeedArticle fa : feedArticles) {
                Article art = transformFeedArticle(fa);
                articleDao.addArticle(art);
                processedArticles++;
            }

        }
        return processedArticles;
    }

    public Article transformFeedArticle(FeedArticle feedArticle) {
        Article article = new Article();
        article.setLink(feedArticle.getLink());
        article.setTitle(feedArticle.getTitle());
        article.setContent(feedArticle.getContent());
        article.setAuthor(feedArticle.getAuthor());
        //article.setCommentsLink("");
        article.setDescription(feedArticle.getDescription());
        article.setPublishedDate(feedArticle.getPublishDate());
        article.setFetchedDate(feedArticle.getPublishDate());

        List<com.keetch.mongo.model.Link> links = new ArrayList<com.keetch.mongo.model.Link>();
        for (Link l : feedArticle.getLinks()) {
            com.keetch.mongo.model.Link link = new com.keetch.mongo.model.Link(l.getUrl(), l.getName());
            links.add(link);
        }
        article.setLinks(links);
        return article;
    }

}
