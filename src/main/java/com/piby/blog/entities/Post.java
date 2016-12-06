package com.piby.blog.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author marco
 *
 */
@Entity
@Table(name = "post")
@SuppressWarnings("unused")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="user_id", nullable=false, updatable=false)
	private User user;

	private String title;
	private Date creationDate;
	private Date updateDate;
	private int views;
	private Double rating;

	@OneToMany(mappedBy = "post")
	private List<Comment> comment;

	@ManyToMany
	private List<Category> categories;

	private Post() {
	}

	public Post(Long id, String title, Date creationDate, Date updateDate, int views, Double rating,
			List<Comment> comment, List<Category> categories) {
		super();
		this.id = id;
		this.title = title;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.views = views;
		this.rating = rating;
		this.comment = comment;
		this.categories = categories;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public User getUser() {
		return user;
	}

	public List<Category> getCategories() {
		return categories;
	}
}
