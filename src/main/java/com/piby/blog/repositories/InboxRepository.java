package com.piby.blog.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.piby.blog.entities.Inbox;

/**
 * @author marco
 *
 */

@RepositoryRestResource
public interface InboxRepository extends PagingAndSortingRepository<Inbox, Long> {

}
