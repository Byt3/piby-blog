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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, Pageable pageable) {
        final Iterable<Post> posts = postRepository.findAll();
        final Iterable<Category> categories = categoryRepository.findAll();
        model.addAttribute("posts", posts);
        model.addAttribute("categories", categories);
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/view/new_post")
    public String getUser(Model model) {
        final Iterable<User> users = userRepository.findAll();
        final Iterable<Category> categories = categoryRepository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("categories", categories);
        return "newPost";
    }

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

//    @RequestMapping(method = RequestMethod.POST, value = "/api/post")
//    public ResponseEntity<Void> saveData(@RequestBody Post post, UriComponentsBuilder ucBuilder){
//        System.out.println("Creating User "+post.getTitle());
//
//        if(postRepository.findByTitle(post.getTitle())) {
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//
//        postRepository.save(post);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(post.getId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//
//    }

//        @RequestMapping(method = RequestMethod.POST, value = BASE_PATH)
//        @ResponseBody
//        public ResponseEntity<?> createFile(@RequestParam("file") MultipartFile file, HttpServletRequest servletRequest) {
//            try {
//                imageService.createImage(file);
//                final URI locationUri = new URI( servletRequest.getRequestURL().toString() + "/" )
//                        .resolve(file.getOriginalFilename() + "/raw");
//    //            return  ResponseEntity.created(request.getURI().resolve(file.getOriginalFilename() + "/raw"))
//    //            .body("Success, file upload " + file.getOriginalFilename());
//                System.out.println(date + " [POST] /images/"+file.getOriginalFilename());
//                return  ResponseEntity.created(locationUri)
//                        .body("Success, file upload " + file.getOriginalFilename());
//
//            } catch (IOException e) {
//                return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                        .body("Filed to upload: " + file.getOriginalFilename() + " : " + e.getMessage());
//            } catch (URISyntaxException e) {
//                e.printStackTrace();
//                return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                        .body("Filed URI Location: " + file.getOriginalFilename() + " : " + e.getMessage());
//            }
//        }



}
