package com.restws.ui.controller.auth;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restws.com.restws.ui.model.vo.auth.LoginVO;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("api/authenticate")
public class AuthController {
	
	Map<String, String> loginMap = new HashMap<>();
	
	@PostMapping
	public LoginVO authenticate(@RequestBody LoginVO login) throws ParseException {
		Map<String, String> loginMap  = getUserDetails();
		if(loginMap.containsKey(login.getUserName())) {
			if(loginMap.get(login.getUserName()).equalsIgnoreCase("admin"))
				return login;
			else
				return new LoginVO(null, null);
		}
		return new LoginVO(null, null);
	}
	
	private Map<String, String> getUserDetails() {
		loginMap.put("admin", "admin");
		return loginMap;
	}

}
