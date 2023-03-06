package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.enums.ErrorConstants;
import com.example.demo.exception.BadAPIResponseException;
import com.example.demo.jwt.JwtTokenUtil;
import com.example.demo.pojo.JwtRequest;
import com.example.demo.pojo.JwtResponse;
import com.example.demo.pojo.UserDTO;
import com.example.demo.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@PostMapping(value = "/login")
	public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
			throws BadAPIResponseException {

		authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
		User user = userDetailsService.getUser();
		//Set<String> userRoles = userDetailsService.getUserRoles(authenticationRequest.getUsername());

		return ResponseEntity.ok(JwtResponse.builder().withJwttoken(jwtTokenUtil.generateToken(userDetails))
				.withUsername(userDetails.getUsername()).withUserId(user.getId()).build());
	}

	@PostMapping(value = "/register")
	public ResponseEntity createUser(@RequestBody UserDTO user)
			throws BadAPIResponseException {

		UserDTO savedUser = userDetailsService.save(user);
		return ResponseEntity.ok().body(savedUser);
	}

	private void authenticate(String username, String password) throws BadAPIResponseException {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (Exception e) {
			throw new BadAPIResponseException(ErrorConstants.INVALID_LOGIN_CRIDENTIALS, null);
		}
	}

	@ResponseBody
	@ExceptionHandler(BadAPIResponseException.class)
	public ResponseEntity<String> handleExceptionScan(BadAPIResponseException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}