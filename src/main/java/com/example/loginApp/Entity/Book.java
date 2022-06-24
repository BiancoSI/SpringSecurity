package com.example.loginApp.Entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter
@ToString

public class Book implements Serializable{
	private Long id;
	private String title;
	private String author;
	
	public Book(Long id, String title, String author) {
		this.id=id; this.title=title; this.author=author;
	}
	
	public boolean equals(Object o) {
		if(this == o) return true;
		if ( ! (o instanceof Book )) return false;
		
		Book b = (Book)o;
		return id.equals(b);
	}
	
	public int hashCode() {
		return (id+" "+title+" "+author) .hashCode();
	}

}
