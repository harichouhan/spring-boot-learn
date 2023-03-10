package com.learn.startup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.startup.configuration.jwt.JwtTokenUtil;
import com.learn.startup.configuration.jwt.JwtUserDetailsService;
import com.learn.startup.model.JwtRequest;
import com.learn.startup.model.JwtResponse;
import com.learn.startup.model.UserRequest;
import com.learn.startup.service.UserService;
	

@RestController
@CrossOrigin
public class JwtAuthenticationController {	

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
    private UserService userService;

	
	/**
	 * Authenticate user and generate token.
	 * @param authenticationRequest
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	
	/**
	 * Register User.
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/register")
	public ResponseEntity<?> saveUser(@RequestBody UserRequest user) throws Exception {
		return ResponseEntity.ok(userService.saveUser(user));
	}

	
	/**
	 * This method responsible to do authentication with valid credentials.
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}