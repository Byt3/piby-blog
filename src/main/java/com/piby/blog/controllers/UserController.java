package com.piby.blog.controllers;

import com.piby.blog.entities.User;
import com.piby.blog.repositories.UserRepository;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.GET, value = "/view/users/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        User user = userRepository.findById(id);
        model.addAttribute("userSelected", user);
        return "singleUser";
    }

}