package com.piby.blog;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.piby.blog.entities.Category;
import com.piby.blog.entities.Comment;
import com.piby.blog.entities.Inbox;
import com.piby.blog.entities.Post;
import com.piby.blog.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PibyBlogApplication {
	public static void main(String[] args) {
		SpringApplication.run(PibyBlogApplication.class, args);
	}

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	@PostConstruct
	public void exposeIds() {
		this.repositoryRestConfiguration.exposeIdsFor(User.class, Post.class, Comment.class, Category.class,
				Inbox.class);
	}

}
