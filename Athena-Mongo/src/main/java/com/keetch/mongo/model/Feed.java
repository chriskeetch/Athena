package com.keetch.mongo.model;

/**
 * Created by keetchc on 29/09/2014.
 */

import com.google.code.morphia.annotations.Entity;

@Entity
public class Feed extends BaseEntity {

    public static final String DBCOLLECTION = "feeds";
    private String title;
    private String url;
    private String category;


    public Feed(String title, String url, String category) {
        this.title = title;
        this.url = url;
        this.category = category;
    }

    public Feed() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Feeds{ID" + id +
                " title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
