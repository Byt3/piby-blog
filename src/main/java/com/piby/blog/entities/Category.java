package com.piby.blog.entities;

import javafx.geometry.Pos;

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
    @JoinColumn(name="user_id")
    private User user;



    public Category(String title, String description, User user) {
        this.title = title;
        this.description = description;
        this.user = user;
    }


    @Override
    public String toString() {
        String result = "";

        //ToDo: Restituire NomeCategoria(num. posts associati)

        return result;
    }


}
