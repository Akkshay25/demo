package com.example.demo.pojo;

import java.io.Serializable;

import javax.annotation.Generated;

public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;

	private String email;

	private String password;

	@Generated("SparkTools")
	private JwtRequest(Builder builder) {
		this.email = builder.username;
		this.password = builder.password;
	}

	public JwtRequest() {
	}

	public JwtRequest(String username, String password) {
		this.setEmail(username);
		this.setPassword(password);
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "JwtRequest [username=" + email + ", password=" + password + "]";
	}

	/**
	 * Creates builder to build {@link JwtRequest}.
	 * 
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link JwtRequest}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private String username;
		private String password;

		private Builder() {
		}

		public Builder withUsername(String username) {
			this.username = username;
			return this;
		}

		public Builder withPassword(String password) {
			this.password = password;
			return this;
		}

		public JwtRequest build() {
			return new JwtRequest(this);
		}
	}

}