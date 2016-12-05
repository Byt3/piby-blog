package com.piby.blog.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.piby.blog.entities.Comment;


/**
 * @author marco
 *
 */


@RepositoryRestResource
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {

}
