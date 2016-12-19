package com.piby.blog.web.controllers;

import com.piby.blog.entities.Post;
import com.piby.blog.repositories.CategoryRepository;
import com.piby.blog.repositories.PostRepository;
import com.piby.blog.repositories.UserRepository;
import com.piby.blog.utility.ResponseParser;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    private static final boolean ACTIVE_LOG = true;
    private static final String BASE_APIV1_PATH = "/api/v1";

    PostRepository postRepository;
    UserRepository userRepository;
    CategoryRepository categoryRepository;
    ResponseParser responseParser = new ResponseParser();

    @Autowired
    public PostController(PostRepository postRepository,
                          UserRepository userRepository,
                          CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/posts")
    ResponseEntity<?> addNewPost(@RequestBody Post post) {
        Post result = postRepository.save(post);
        if (this.postRepository.findByTitle(result.getTitle()) != null) {
            return responseParser.generateResponseEntity("POST", true, post, ACTIVE_LOG);
        } else return responseParser.generateResponseEntity("POST", false, new JSONObject(), ACTIVE_LOG);
    }


}
