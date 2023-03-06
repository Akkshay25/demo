package com.example.demo.pojo;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;

	private String jwttoken;

	private String username;

	private Long userId;

	private Set<String> roles;

	@Generated("SparkTools")
	private JwtResponse(Builder builder) {
		this.jwttoken = builder.jwttoken;
		this.username = builder.username;
		this.userId = builder.userId;
		this.roles = builder.roles;
	}

	public String getJwttoken() {
		return jwttoken;
	}

	public void setJwttoken(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getUsername() {
		return username;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "JwtResponse [jwttoken=" + jwttoken + ", username=" + username + ", roles=" + roles + "]";
	}

	/**
	 * Creates builder to build {@link JwtResponse}.
	 * 
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link JwtResponse}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private String jwttoken;
		private String username;
		private Long userId;
		private Set<String> roles = Collections.emptySet();

		private Builder() {
			super();
		}

		public Builder withJwttoken(String jwttoken) {
			this.jwttoken = jwttoken;
			return this;
		}

		public Builder withUsername(String username) {
			this.username = username;
			return this;
		}

		public Builder withUserId(Long userId) {
			this.userId = userId;
			return this;
		}

		public Builder withRoles(Set<String> roles) {
			this.roles = roles;
			return this;
		}

		public JwtResponse build() {
			return new JwtResponse(this);
		}
	}

}