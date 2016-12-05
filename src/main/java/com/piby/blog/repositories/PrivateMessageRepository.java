/**
 * 
 */
package com.piby.blog.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.piby.blog.entities.PrivateMessage;

/**
 * @author marco
 *
 */

@RepositoryRestResource
public interface PrivateMessageRepository extends PagingAndSortingRepository<PrivateMessage, Long> {

}
