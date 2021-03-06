package com.piby.blog.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author marco
 *
 */
@Entity
@Table(name = "user")
@SuppressWarnings("unused")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4902853574452836518L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	private String password;
	private int age;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Post> post;
	@OneToMany(mappedBy = "user")
	private List<Comment> comment;
	@OneToOne
	private Inbox inbox;

	private User() {
	}

	public User(Long id, String name, String email, String password, int age, List<Post> post, List<Comment> comment,
			Inbox inbox) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.age = age;
		this.post = post;
		this.comment = comment;
		this.inbox = inbox;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Inbox getInbox() {
		return inbox;
	}

	public void setInbox(Inbox inbox) {
		this.inbox = inbox;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

}
