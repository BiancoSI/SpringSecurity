package com.example.loginApp.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "utenti")
public class User implements Serializable{
	
	@Id
	@Column(name = "ID", length = 36, nullable = false)
	private String id;
	
	@Column(name = "classe", length=1)
	private String rank;

}

