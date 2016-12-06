package com.piby.blog.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.piby.blog.entities.Inbox;

/**
 * @author marco
 *
 */
@Repository
@RepositoryRestResource
public interface InboxRepository extends PagingAndSortingRepository<Inbox, Long> {

}
