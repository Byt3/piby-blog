package com.piby.blog.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author marco
 *
 */

@Entity
@Table(name = "private_messages")
public class PrivateMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3744656510094686707L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String productName;
	private String productDesc;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "inbox_id", nullable = false)
	private Inbox inbox;

	private PrivateMessage() {
	}

	public PrivateMessage(Long id, String productName, String productDesc) {
		super();
		this.id = id;
		this.productName = productName;
		this.productDesc = productDesc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public Inbox getInbox() {
		return inbox;
	}

	public void setInbox(Inbox inbox) {
		this.inbox = inbox;
	}

}
