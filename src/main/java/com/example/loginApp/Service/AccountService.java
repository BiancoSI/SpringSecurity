package com.example.loginApp.Service;


import java.util.Base64;


import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.loginApp.utility.JwtValidator;



@Service
public class AccountService {
	
	
	public boolean decodeJWT(String token) {
		DecodedJWT decoded = new JwtValidator().validate(token);
		System.out.println(decoded.getPayload());
		Base64.Decoder decoder = Base64.getDecoder();
		String header = new String ( decoder.decode(decoded.getHeader()) );
		String payload = new String ( decoder.decode(decoded.getPayload()) );
		System.out.println(header+"\n"+payload);
		JSONObject json = new JSONObject(payload);
		System.out.println(json.get("sub"));
		return true;
	}
}
