package com.miki.blog.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by mcsere on 7/8/2015.
 */
@Document
public class Author extends AbstractEntity {

    private String name;

    private String registerNumber;

    public Author(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }
}
