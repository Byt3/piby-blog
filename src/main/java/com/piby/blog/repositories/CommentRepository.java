package com.piby.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.piby.blog.entities.Comment;
import com.piby.blog.entities.User;


/**
 * @author marco
 *
 */


@RepositoryRestResource
public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	Iterable<Comment> findAllByUserIdAndParentNotNull(@Param("user") Long user);

}
