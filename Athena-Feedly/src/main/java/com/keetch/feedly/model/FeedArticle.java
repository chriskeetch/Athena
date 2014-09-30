package com.keetch.feedly.model;

import java.util.Date;
import java.util.List;

/**
 * Created by keetchc on 30/09/2014.
 */
public class FeedArticle {


    private String author;
    private String title;
    private String link;
    private String description;
    private Date publishDate;
    private Date fetchedDate;
    private String content;
    private String parentFeed;
    private List<Link> links;

    // Metadata
    private boolean read = false;


    public String getParentFeed() {
        return parentFeed;
    }

    public void setParentFeed(String parentFeed) {
        this.parentFeed = parentFeed;
    }

    public Date getFetchedDate() {
        return fetchedDate;
    }

    public void setFetchedDate(Date fetchedDate) {
        this.fetchedDate = fetchedDate;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "FeedArticle{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", publishDate=" + publishDate +
                ", fetchedDate=" + fetchedDate +
                ", content='" + content + '\'' +
                ", parentFeed='" + parentFeed + '\'' +
                ", read=" + read +
                '}';
    }
}
