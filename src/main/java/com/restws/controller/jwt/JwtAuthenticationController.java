package com.restws.controller.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restws.com.restws.jwt.model.JwtRequest;
import com.restws.com.restws.jwt.model.JwtResponse;
import com.restws.com.restws.ui.model.User;
import com.restws.com.restws.ui.model.vo.auth.LoginVO;
import com.restws.config.JwtTokenUtil;
import com.restws.service.JwtUserDetailsService;
@RestController
@CrossOrigin
@RequestMapping({"/authWithJWT"})
public class JwtAuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private JwtUserDetailsService userDetailsService;

	@PostMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
//	@RequestMapping(value = "/authWithJWT", method = RequestMethod.POST)
	public ResponseEntity<LoginVO> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		authenticate(authenticationRequest.getUserName(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUserName());
		
		final String token = jwtTokenUtil.generateToken(userDetails);
		List<String> roles = new ArrayList<>();
		for(GrantedAuthority role: userDetails.getAuthorities()) {
			roles.add(role.getAuthority());
		}
				
		LoginVO userToken = new LoginVO(authenticationRequest.getUserName(), authenticationRequest.getPassword(), token, roles);
		return ResponseEntity.ok(userToken);
	}
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	
	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> getUser() {
		User returnUser = new User("first", "last", "email", "25");

		return new ResponseEntity<User>(returnUser,HttpStatus.OK);
	}
}
