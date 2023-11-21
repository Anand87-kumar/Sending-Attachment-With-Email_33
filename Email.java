package com.anand.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "emails")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String toEmail;
    private String subject;
    private String text;
	public Email() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Email(Long id, String toEmail, String subject, String text) {
		super();
		this.id = id;
		this.toEmail = toEmail;
		this.subject = subject;
		this.text = text;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getToEmail() {
		return toEmail;
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "Email [id=" + id + ", toEmail=" + toEmail + ", subject=" + subject + ", text=" + text + "]";
	}

}

