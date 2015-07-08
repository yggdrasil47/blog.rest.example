package com.miki.blog.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mcsere on 7/8/2015.
 */
@Document
public class Article extends AbstractEntity {

    private String title;

    private String content;

    @Indexed(unique = true)
    private String isbdn;


    private List<String> authorsList = new ArrayList<String>();

    public List<String> getAuthorsList() {
        return authorsList;
    }

    public void setAuthorsList(List<String> authorsList) {
        this.authorsList = authorsList;
    }

    public void addAuthor(Author author) {
        this.authorsList.add(author.getId());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIsbdn() {
        return isbdn;
    }

    public void setIsbdn(String isbdn) {
        this.isbdn = isbdn;
    }
}
