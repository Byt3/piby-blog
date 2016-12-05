package com.piby.blog.repositories;

import com.piby.blog.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Lorenzo on 05/12/16.
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Category findByTitle(@Param("title") String title);

}
