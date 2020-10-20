package com.RemiVincent.web;

public class Todo {
	private int id;
	private String text;
	
	public Todo(int id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
	
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
