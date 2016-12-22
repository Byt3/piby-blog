package com.piby.blog.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * @author marco
 *
 */
@Entity
@Table(name = "user")
@SuppressWarnings("unused")
public class User implements Serializable {

	private static final long serialVersionUID = -4902853574452836518L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(name = "is_autor", nullable = false)
	private boolean isAutor = false;
	private String password;
	private int age;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Post> posts;
	@OneToMany(mappedBy = "user")
	private List<Comment> comment;
	@OneToOne
	private Inbox inbox;

	public User() { }

	public User(Long id, String name, String email, String password, int age, List<Post> posts, List<Comment> comment,
			Inbox inbox, String username) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.age = age;
		this.posts = posts;
		this.comment = comment;
		this.username = username;
		this.inbox = inbox;
		this.isAutor = false;
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
		return posts;
	}

	public void setPost(List<Post> posts) {
		this.posts = posts;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isAutor() {
		return isAutor;
	}

	public void setAutor(boolean autor) {
		isAutor = autor;
	}

}
