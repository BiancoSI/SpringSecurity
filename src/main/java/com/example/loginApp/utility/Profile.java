package com.example.loginApp.utility;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Profile implements Serializable{
	private String 
		username,  
		email,
		first_name,
		last_name,
		rank,
		date_of_registration
		;
	private int total_days_of_overnight_stay;
}
