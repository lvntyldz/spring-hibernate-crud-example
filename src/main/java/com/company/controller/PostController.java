package com.company.controller;

import com.company.domain.Post;
import com.company.domain.PostComment;
import com.company.util.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @RequestMapping(value = {"/post"}, method = RequestMethod.GET)
    public ModelAndView post() {
        ModelAndView mv = new ModelAndView("post");

        HibernateUtil hibernateUtil = new HibernateUtil();
        List<Post> postList = hibernateUtil.findAllPost();

        mv.addObject("posts", postList);

        return mv;
    }

    @RequestMapping(value = {"/post-add"}, method = RequestMethod.GET)
    public String postAdd(HttpServletRequest request) {

        HibernateUtil hibernateUtil = new HibernateUtil();

        //create session
        Session session = hibernateUtil.openSession();

        //start transactions
        session.beginTransaction();

        PostComment comment1 = new PostComment();
        comment1.setReview("yess");

        PostComment comment2 = new PostComment();
        comment2.setReview("Nope");

        PostComment comment3 = new PostComment();
        comment3.setReview("Hey!");

        List<PostComment> comments = new ArrayList<>();
        comments.add(comment1);
        comments.add(comment2);
        comments.add(comment3);

        Post post = new Post();
        post.setTitle("Yorum");
        post.setComments(comments);

        session.save(post);

        //-----

        PostComment comment4 = new PostComment();
        comment4.setReview("yess");

        PostComment comment5 = new PostComment();
        comment5.setReview("Nope");

        List<PostComment> comments2 = new ArrayList<>();
        comments2.add(comment5);
        comments2.add(comment4);

        Post post2 = new Post();
        post2.setTitle("Yorum2");
        post2.setComments(comments2);

        session.save(post2);

        //commit transaction
        session.getTransaction().commit();

        //close session
        session.close();

        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

}
