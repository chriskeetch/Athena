package com.keetch.feedly;

import com.keetch.feedly.model.FeedArticle;
import com.keetch.feedly.model.Link;
import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndPerson;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by keetchc on 30/09/2014.
 */
public class FeedReader {

    public List<FeedArticle> read(String feedURL) {
        URL feedSource = null;
        List<Link> listOfLinks = new ArrayList<Link>();
        List<FeedArticle> feedArticles = new ArrayList<FeedArticle>();
        try {
            feedSource = new URL(feedURL);
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedSource));


            //loop around entries to find indivual articles
            for (SyndEntry se : feed.getEntries()) {
                FeedArticle article = transformFeedData(se);
                if (article.getContent() != null) {
                    article.setLinks(ExtractLinks.process(article.getContent(), article.getLink()));
                    article.setParentFeed(feedURL);
                    feedArticles.add(article);
                    listOfLinks.addAll(article.getLinks());
                }
            }

        } catch (MalformedURLException e) {
            // e.printStackTrace();
            System.out.println("1");
        } catch (FeedException e) {
            // e.printStackTrace();
            System.out.println("2");
        } catch (IOException e) {
            // e.printStackTrace();
            System.out.println("3");
        }
        return feedArticles;
    }

    public FeedArticle transformFeedData(SyndEntry feed) {
        FeedArticle feedArticle = new FeedArticle();
        List<SyndPerson> authors = feed.getAuthors();
        feedArticle.setAuthor(feed.getAuthor());
        if (feed.getDescription() != null)
            feedArticle.setDescription(feed.getDescription().getValue());
        feedArticle.setLink(feed.getLink());
        feedArticle.setPublishDate(feed.getPublishedDate());
        feedArticle.setFetchedDate(new Date());
        feedArticle.setTitle(feed.getTitle());

        if (feed.getContents().size() > 0) {
            SyndContent content = feed.getContents().get(0);
            feedArticle.setContent(content.getValue());
        }
        //article.setCategory();
        //article.setTags();
        //System.out.println(feedArticle);
        return feedArticle;
    }
}
