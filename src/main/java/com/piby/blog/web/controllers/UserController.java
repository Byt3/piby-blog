package com.piby.blog.web.controllers;

import com.piby.blog.entities.User;
import com.piby.blog.repositories.UserRepository;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

//    @RequestMapping(value = "/api/users", method = RequestMethod.POST)
//    public ResponseEntity<User> addNewUser(@RequestBody User user, HttpServletRequest servletRequest) throws URISyntaxException {
//        userRepository.save(user);
//        User userCreated = userRepository.findOne(user.getId());
//        return new ResponseEntity<User>(userCreated, HttpStatus.CREATED);
//    }

}