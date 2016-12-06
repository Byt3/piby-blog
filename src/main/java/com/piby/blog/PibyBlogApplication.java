package com.piby.blog;

import com.piby.blog.repositories.CategoryRepository;
import com.piby.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@SpringBootApplication
public class PibyBlogApplication {

//	@Autowired
//	private CategoryRepository categoryRepository;
//
//	@Autowired
//	private PostRepository postRepository;

	public static void main(String[] args) {
		SpringApplication.run(PibyBlogApplication.class, args);
	}

}
