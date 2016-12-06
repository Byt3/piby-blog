package com.piby.blog.entities;


import javax.persistence.*;
import java.util.List;

/**
 * Created by Lorenzo on 05/12/16.
 */
@Entity
@Table(name = "category")
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    @ManyToOne
    private User user;
    @ManyToMany
    @JoinTable(
            name="category2project",
            joinColumns=@JoinColumn(name="category_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="post_id", referencedColumnName="id"))
    private List<Post> posts;


    public Category(String title, String description, User user, List<Post> posts) {
        this.title = title;
        this.description = description;
        this.user = user;
        this.posts = posts;
    }


    @Override
    public String toString() {
        return this.title + "(" + this.posts.size() + ")";
    }


}
