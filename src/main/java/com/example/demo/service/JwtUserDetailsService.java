package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.enums.ErrorConstants;
import com.example.demo.exception.BadAPIResponseException;
import com.example.demo.pojo.UserDTO;
import com.example.demo.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class JwtUserDetailsService implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(JwtUserDetailsService.class);

	@Autowired
	private UsersRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	private User user;

	public User getUser() {
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws BadAPIResponseException {

		try {
			logger.debug("Inside JwtUserDetailsService: loadUserByUsername()");

			user = userDao.findByUsername(username);
			if (user == null) {
				throw new BadAPIResponseException(ErrorConstants.INVALID_LOGIN_CRIDENTIALS, null);
			}
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					new ArrayList<>());
		} catch (BadAPIResponseException e) {

			throw new BadAPIResponseException(ErrorConstants.INVALID_LOGIN_CRIDENTIALS, null);
		} catch (Exception e) {
			logger.error("exception occured :{}", e.getMessage());
			throw new BadAPIResponseException(ErrorConstants.INTERNAL_ERROR_OCCURED, null);
		}

	}

	public UserDTO save(UserDTO user) throws BadAPIResponseException {
		logger.debug("Inside JwtUserDetailsService: save()");

		if (user.getPassword() != null) {
			User newUser = User.builder().withUsername(user.getUsername()).withUserType(user.getUserType())
					.withEmail(user.getEmail()).withPhoneNumber(user.getPhoneNumber()).withStatus(user.getStatus())
					.withPassword(bcryptEncoder.encode(user.getPassword())).build();

			User savedUser = userDao.save(newUser);

			return convertToDto(savedUser);

		} else {
			throw new BadAPIResponseException(ErrorConstants.MANDATORY_FIELD, null);
		}
	}

//	public Set<String> getUserRoles(String username) throws BadAPIResponseException {
//		logger.debug("Inside JwtUserDetailsService: getUserRoles()");
//		try {
//			return userDao.findRoleByUsername(username);
//		} catch (Exception e) {
//			logger.error("exception occured :{}", e.getMessage());
//			throw new BadAPIResponseException(ErrorConstants.INTERNAL_ERROR_OCCURED, null);
//		}
//	}

	private UserDTO convertToDto(User user) {

		UserDTO.Builder getUsersDto = UserDTO.builder();
		logger.error("user is : {}", user);

		getUsersDto.withId(user.getId()).withUsername(user.getUsername()).withUserType(user.getUserType())
				.withPassword(user.getPassword()).withEmail(user.getEmail()).withPhoneNumber(user.getPhoneNumber())
				.withStatus(user.getStatus());
		return getUsersDto.build();

	}
}