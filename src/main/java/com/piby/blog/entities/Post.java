package com.piby.blog.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author marco
 *
 */
@Entity
@Table(name = "post")
@SuppressWarnings("unused")
public class Post implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2948690854716125077L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "users_id", nullable = false)
	private User user;
	private String title;
	private String text;
	private Date creationDate;
	private Date updateDate;
	private int views;
	@JsonIgnore
	private Double rating;
	@OneToMany(mappedBy = "post")
	private List<Comment> comment;
	@ManyToMany(mappedBy = "posts")
	private List<Category> categories;

	private Post() {
	}

	public Post(Long id, User user, String title, String text, Date creationDate, Date updateDate, int views,
			Double rating, List<Comment> comment, List<Category> categories) {
		super();
		this.id = id;
		this.user = user;
		this.title = title;
		this.text = text;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.views = views;
		this.rating = rating;
		this.comment = comment;
		this.categories = categories;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
