package com.piby.blog.controllers;

import com.piby.blog.entities.User;
import com.piby.blog.repositories.UserRepository;
import jdk.nashorn.api.scripting.JSObject;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/api/users", method = RequestMethod.POST)
    public ResponseEntity<User> addNewUser(@RequestBody User user, HttpServletRequest servletRequest) throws URISyntaxException {
        userRepository.save(user);
        User userCreated = userRepository.findOne(user.getId());
        return new ResponseEntity<User>(userCreated, HttpStatus.CREATED);
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/api/users")
//    @ResponseBody
//    public ResponseEntity<?> getFile(@PathVariable String name) {
//        User user = userRepository.findByName(name);
//        return new ResponseEntity<User>(user, HttpStatus.CREATED);
//    }

}