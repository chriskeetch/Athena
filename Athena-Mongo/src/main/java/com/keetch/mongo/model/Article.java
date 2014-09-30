package com.keetch.mongo.model;

import com.google.code.morphia.annotations.Entity;

import java.util.Date;
import java.util.List;

/**
 * Created by keetchc on 30/09/2014.
 */

@Entity
public class Article extends BaseEntity {

    private String author;
    private String title;
    private String link;
    private String commentsLink;
    private String description;
    private String content;
    private Date publishedDate;
    private Date fetchedDate;
    private boolean read;
    private String parentFeed;
    private List<Link> links;

    public Article(String author, String title, String link, String commentsLink, String description, String content, Date publishedDate, Date fetchedDate, boolean read, String parentFeed) {
        this.author = author;
        this.title = title;
        this.link = link;
        this.commentsLink = commentsLink;
        this.description = description;
        this.content = content;
        this.publishedDate = publishedDate;
        this.fetchedDate = fetchedDate;
        this.read = read;
        this.parentFeed = parentFeed;
    }


    public Article() {

    }

    public boolean isRead() {
        return read;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

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

    public String getCommentsLink() {
        return commentsLink;
    }

    public void setCommentsLink(String commentsLink) {
        this.commentsLink = commentsLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", commentsLink='" + commentsLink + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", publishedDate=" + publishedDate +
                ", fetchedDate=" + fetchedDate +
                ", read=" + read +
                ", parentFeed='" + parentFeed + '\'' +
                ", links=" + links +
                '}';
    }
}
