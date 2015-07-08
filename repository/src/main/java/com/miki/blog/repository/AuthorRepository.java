package com.miki.blog.repository;

import com.miki.blog.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by mcsere on 7/8/2015.
 */
public interface AuthorRepository extends MongoRepository<Author, Long> {

    List<Author> findByName(String name);

    @Query("{ ?0 : ?1 }")
    List<Author> findByAttributes(String key, String value);

}
