package com.piby.blog;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.piby.blog.entities.User;

@RepositoryRestController
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	//make the repo dirty
	User findByName(String name);
}
