package com.piby.blog.web;

import com.piby.blog.entities.Category;
import com.piby.blog.entities.Post;
import com.piby.blog.entities.User;
import com.piby.blog.repositories.CategoryRepository;
import com.piby.blog.repositories.PostRepository;
import com.piby.blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RoutingPages {

    PostRepository postRepository;
    UserRepository userRepository;
    CategoryRepository categoryRepository;

    @Autowired
    public RoutingPages(PostRepository postRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, Pageable pageable) {
        final Iterable<Post> posts = postRepository.findAll();
        final Iterable<Category> categories = categoryRepository.findAll();
        model.addAttribute("posts", posts);
        model.addAttribute("categories", categories);
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/new_post")
    public String getUser(Model model) {
        final Iterable<User> users = userRepository.findAll();
        final Iterable<Category> categories = categoryRepository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("categories", categories);
        return "newPost";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        User user = userRepository.findById(id);
        model.addAttribute("userSelected", user);
        return "singleUser";
    }


}
