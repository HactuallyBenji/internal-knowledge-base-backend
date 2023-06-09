package org.example.controller;

import org.example.data.ArticleDBDao;
import org.example.models.Article;
import org.example.models.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class KBController {
    private final ArticleDBDao articleDAO;

    public KBController(ArticleDBDao articleDAO) {
        this.articleDAO = articleDAO;
    }

    @GetMapping("/article/{authorizedRole}")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Article> getAllByRole(@PathVariable String authorizedRole) {
        return articleDAO.getAllByRole(authorizedRole);
    }

    @GetMapping("/comment/{articleID}")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Comment> getAllCommentsByArticleID(@PathVariable int articleID) {
        return articleDAO.getAllCommentsByArticleID(articleID);
    }

    @PostMapping("/article")
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseStatus(HttpStatus.CREATED)
    public void addArticle(@RequestBody Article article) {
        System.out.println(article.getReadStatus());
        articleDAO.addArticle(article);
    }

    @DeleteMapping("/article/delete/{articleID}")
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteArticleByID(@PathVariable int articleID) {
        // delete comments before deleting the article with the foreign key
        System.out.println("DELETING");
        articleDAO.deleteCommentsForArticleID(articleID);
        articleDAO.deleteArticleByID(articleID);
    }

    @PostMapping("/comment")
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseStatus(HttpStatus.CREATED)
    public void addComment(@RequestBody Comment comment) {
        articleDAO.addComment(comment);
    }

    @PostMapping("/comment/{commentID}")
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCommentByID(@PathVariable int commentID) {
        articleDAO.deleteCommentByID(commentID);
    }

    @PostMapping("/article/read/{articleID}")
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void setRead(@PathVariable int articleID) {
        articleDAO.setRead(articleID);
    }

    @PostMapping("/article/unread/{articleID}")
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void setUnread(@PathVariable int articleID) {
        articleDAO.setUnread(articleID);
    }
}
