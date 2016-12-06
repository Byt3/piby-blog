package com.piby.blog.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author marco
 *
 */

@Entity
@Table(name = "comment")
@SuppressWarnings("unused")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String text;
	private String title;
	private Date creationDate;
	private Date updateDate;
	private String editedBy;
	@ManyToOne
	private User user;
	@ManyToOne
	private Post post;
	@ManyToOne
	private Comment parent;
	@OneToMany(mappedBy = "parent")
	private List<Comment> children;

	private Comment() {
	}

	public Comment(Long id, String text, String title, Date creationDate, Date updateDate, String editedBy, User user,
			Post post, Comment parent, List<Comment> children) {
		super();
		this.id = id;
		this.text = text;
		this.title = title;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.editedBy = editedBy;
		this.user = user;
		this.post = post;
		this.parent = parent;
		this.children = children;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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

	public String getEditedBy() {
		return editedBy;
	}

	public void setEditedBy(String editedBy) {
		this.editedBy = editedBy;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Comment getParent() {
		return parent;
	}

	public void setParent(Comment parent) {
		this.parent = parent;
	}

	public List<Comment> getChildren() {
		return children;
	}

	public void setChildren(List<Comment> children) {
		this.children = children;
	}

	
}
