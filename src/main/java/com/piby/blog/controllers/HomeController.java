package com.piby.blog.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.piby.blog.entities.Category;
import com.piby.blog.entities.Post;
import com.piby.blog.entities.User;
import com.piby.blog.repositories.CategoryRepository;
import com.piby.blog.repositories.PostRepository;
import com.piby.blog.repositories.UserRepository;
import com.sun.org.apache.xerces.internal.util.URI;
import javafx.geometry.Pos;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HomeController {

    PostRepository postRepository;
    UserRepository userRepository;
    CategoryRepository categoryRepository;

    @Autowired
    public HomeController(PostRepository postRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }


    // TODO: gestire
    @RequestMapping(method = RequestMethod.POST, value = "/api/posts",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> addNewPost(Post post) {
        if(this.postRepository.findByTitle(post.getTitle())) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        //TODO: Add date
        postRepository.save(post);

        return new ResponseEntity<Post>(post, HttpStatus.OK);

    }

}
