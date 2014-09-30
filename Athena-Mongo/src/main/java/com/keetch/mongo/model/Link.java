package com.keetch.mongo.model;

/**
 * Created by keetchc on 30/09/2014.
 */

public class Link {

    private String url;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Link(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public Link() {
    }

    @Override
    public String toString() {
        return "Link{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
