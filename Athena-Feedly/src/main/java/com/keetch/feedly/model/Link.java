package com.keetch.feedly.model;

/**
 * Created by keetchc on 30/09/2014.
 */
public class Link {

    private String url;
    private String parentArticleUrl;
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

    public String getParentArticleUrl() {
        return parentArticleUrl;
    }

    public void setParentArticleUrl(String parentArticleUrl) {
        this.parentArticleUrl = parentArticleUrl;
    }
}
