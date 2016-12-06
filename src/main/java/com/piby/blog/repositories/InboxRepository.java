package com.piby.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.piby.blog.entities.Inbox;

/**
 * @author marco
 *
 */

@RepositoryRestResource
public interface InboxRepository extends JpaRepository<Inbox, Long> {

}
