package com.piby.blog.controllers;

import com.piby.blog.entities.Post;
import com.piby.blog.entities.User;
import com.piby.blog.repositories.PostRepository;
import com.piby.blog.repositories.UserRepository;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, Pageable pageable) {
        final Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/view/new_post")
    public String getUser(Model model) {
        final Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "newPost";
    }

}
