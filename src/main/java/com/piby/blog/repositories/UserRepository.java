package com.piby.blog.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.piby.blog.entities.User;

/**
 * @author marco
 *
 */

@RepositoryRestResource
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	User findByName(@Param("name") String name);

	Iterable<User> findByNameOrderByAgeAsc(@Param("name") String name);
}
