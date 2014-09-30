package com.keetch.mongo.dao;

import com.google.code.morphia.Key;
import com.keetch.mongo.model.Article;

import java.util.List;

/**
 * Created by keetchc on 30/09/2014.
 */
public class ArticleDAO extends BaseDAO {


    public Key<Article> addArticle(Article article) {
        return getDatastore().save(article);
    }


    public List<Article> listFeeds() {
        return getDatastore().find(Article.class).asList();

    }

    public void deleteAll() {
        getDatastore().delete(getDatastore().createQuery(Article.class));
    }

}
