package com.piby.blog.repositories;

import jdk.nashorn.api.scripting.JSObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.piby.blog.entities.User;

/**
 * @author marco
 *
 */

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {

	User findByName(@Param("name") String name);

	User findById(@Param("id") Long id);

	Iterable<User> findByNameOrderByAgeAsc(@Param("name") String name);

	User save(@Param("user") JSObject user);

}