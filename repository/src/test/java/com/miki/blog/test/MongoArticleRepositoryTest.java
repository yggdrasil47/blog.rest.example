package com.miki.blog.test;

import com.miki.blog.ApplicationConfig;
import com.miki.blog.model.Article;
import com.miki.blog.model.Author;
import com.miki.blog.repository.ArticleRepository;
import com.miki.blog.repository.AuthorRepository;
import com.miki.blog.util.IsbdnGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by mcsere on 7/8/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class MongoArticleRepositoryTest {

    @Resource
    ArticleRepository articleRepository;

    @Resource
    AuthorRepository authorRepository;


    @Test
    public void testSaveAuthor() {
        Author author = new Author();
        author.setName("Ion Creanga");
        author = authorRepository.save(author);

        List<Author> actual = authorRepository.findByName(author.getName());

        assertTrue(actual.contains(author));

        actual = authorRepository.findByAttributes("name", author.getName());
        assertTrue(actual.contains(author));
    }

    @Test
    public void testSaveArticle() {
        Author author = authorRepository.findAll().get(0);

        Article article = new Article();
        article.setContent("content");
        article.setTitle("title");
        article.setIsbdn(IsbdnGenerator.generate());

        if (author != null) {
            article.addAuthor(author);
        }

        article = articleRepository.save(article);

        Article actual = articleRepository.findById(article.getId());

        assertEquals(article.getTitle(), actual.getTitle());
    }

}
