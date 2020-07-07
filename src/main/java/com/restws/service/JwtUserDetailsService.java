package com.restws.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	/**
	 * Also the password for a user is stored in encrypted format using BCrypt. 
	 * Previously we have seenSpring Boot Security — 
	 * Password Encoding Using Bcrypt. 
	 * Here using the Online Bcrypt Generator you can generate the Bcrypt for a password.
	 * https://www.javainuse.com/onlineBcrypt
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = null;
		if ("javainuse".equals(username)) {
			// password: "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6"
			List<String> roles = new ArrayList<>();
			roles.add("USER");
			user = new User("javainuse", bcryptEncoder.encode("password"),
					getAuthority(roles));
			return user;
			
		} else if("admin".equals(username)) {
			List<String> roles = new ArrayList<>();
			roles.add("ADMIN");
			user = new User("admin", bcryptEncoder.encode("password"),
					getAuthority(roles));
			return user;
		}
		else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
	
	private Set getAuthority(List<String> roles) {
        Set authorities = new HashSet<>();
        roles.forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		});
		return authorities;
	}

	
	
}