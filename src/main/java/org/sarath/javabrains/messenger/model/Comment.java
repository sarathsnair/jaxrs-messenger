package org.sarath.javabrains.messenger.model;

import java.util.Date;

public class Comment {
	private long id;
	private String commentMessage;
	private Date created;
	private String author;

	public Comment() {

	}

	public Comment(long id, String commentMessage, String author) {
		this.id = id;
		this.commentMessage = commentMessage;
		this.created = new Date();
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCommentMessage() {
		return commentMessage;
	}

	public void setCommentMessage(String commentMessage) {
		this.commentMessage = commentMessage;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
