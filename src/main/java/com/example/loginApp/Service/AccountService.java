package com.example.loginApp.Service;


import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.Date;

import org.json.JSONObject;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.loginApp.Repository.UtentiRepository;
import com.example.loginApp.Supports.RequestKeycloak;
import com.example.loginApp.utility.JwtValidator;
import com.example.loginApp.utility.Profile;



@Service
public class AccountService {
	@Autowired
	private UtentiRepository us ;
	
	private Keycloak keycloak = new RequestKeycloak().keycloak();
	@Value("${keycloak.realm}")
	private String realm;
	
	public String decodeJWT(String token) throws InvalidParameterException{
		DecodedJWT decoded = new JwtValidator().validate(token);
		System.out.println(decoded.getPayload());
		Base64.Decoder decoder = Base64.getDecoder();
		String header = new String ( decoder.decode(decoded.getHeader()) );
		String payload = new String ( decoder.decode(decoded.getPayload()) );
		System.out.println(header+"\n"+payload);
		JSONObject json = new JSONObject(payload);
		return (String)json.get("sub");
	}
	public Profile getUserById(String id) {
		UserRepresentation user = keycloak.realm(realm)
			.users()
			.get(id)
			.toRepresentation();
		Profile p = new Profile();
		p.setEmail(user.getEmail()); p.setFirst_name(user.getFirstName()); p.setLast_name(user.getLastName());
		Date d = new Date(user.getCreatedTimestamp());
		
		p.setDate_of_registration(""+(d.getYear()+1900)+"/"+(d.getMonth() +1) +"/"+d.getDate());
		p.setRank(us.getById(id).getRank());
		p.setTotal_days_of_overnight_stay(0);
		p.setUsername(user.getUsername());
		return p;
	}
}
