package com.piby.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.piby.blog.entities.Category;

/**
 * Created by Lorenzo on 05/12/16.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByTitle(@Param("title") String title);

}
