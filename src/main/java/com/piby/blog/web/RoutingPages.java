package com.piby.blog.web;

import com.piby.blog.entities.Category;
import com.piby.blog.entities.Post;
import com.piby.blog.entities.User;
import com.piby.blog.repositories.CategoryRepository;
import com.piby.blog.repositories.PostRepository;
import com.piby.blog.repositories.UserRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    JSONObject generalSetting = new JSONObject();

    @Autowired
    public RoutingPages(PostRepository postRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.generalSetting.put("view", "home");
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, Pageable pageable) {

        if (pageable.getPageNumber() == 0) {
            pageable = new PageRequest(0, 3);
        }
        final Page<Post> page = postRepository.findAll(pageable);
        model.addAttribute("page", page);
        if (page.hasPrevious()) {
            model.addAttribute("prev", pageable.previousOrFirst());
        }
        if (page.hasNext()) {
            model.addAttribute("next", pageable.next());
        }

        final Iterable<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        this.generalSetting.put("view", "home");
        model.addAttribute("generalSetting", this.generalSetting);
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/new_post")
    public String getUser(Model model) {
        final Iterable<User> users = userRepository.findAll();
        final Iterable<Category> categories = categoryRepository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("categories", categories);
        this.generalSetting.put("view", "newPost");
        model.addAttribute("generalSetting", this.generalSetting);
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        User user = userRepository.findById(id);
        model.addAttribute("userSelected", user);
        return "singleUser";
    }


}
