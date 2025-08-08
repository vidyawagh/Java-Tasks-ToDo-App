package com.ToDoApp.model;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.NonNull;




@Entity
@Table (name="todo")
public class ToDo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NonNull
	private long id;
	@Column
	private String title;
	@Column
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date date;
	@Column
	private String status;
	public ToDo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
		
	}


