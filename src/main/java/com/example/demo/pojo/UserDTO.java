package com.example.demo.pojo;

import javax.annotation.Generated;

public class UserDTO {

	private Long id;

	private String status;

	private String username;

	private String password;

	private String email;

	private String phoneNumber;

	private String userType;

	public UserDTO() {
	}

	public UserDTO(Long id, String status, String username, String password, String email, String phoneNumber,
			String userType, String createdDate, Long createdBy, String modifiedDate, Long modifiedBy) {
		super();
		this.id = id;
		this.status = status;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userType = userType;
	}

	@Generated("SparkTools")
	private UserDTO(Builder builder) {
		this.id = builder.id;
		this.status = builder.status;
		this.username = builder.username;
		this.password = builder.password;
		this.email = builder.email;
		this.phoneNumber = builder.phoneNumber;
		this.userType = builder.userType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}


	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", status=" + status + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", userType=" + userType + ", createdDate="
				+ "]";
	}

	/**
	 * Creates builder to build {@link UserDTO}.
	 * 
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link UserDTO}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private Long id;
		private String status;
		private String username;
		private String password;
		private String email;
		private String phoneNumber;
		private String userType;

		private Builder() {
		}

		public Builder withId(Long id) {
			this.id = id;
			return this;
		}

		public Builder withStatus(String status) {
			this.status = status;
			return this;
		}

		public Builder withUsername(String username) {
			this.username = username;
			return this;
		}

		public Builder withPassword(String password) {
			this.password = password;
			return this;
		}

		public Builder withEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder withPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public Builder withUserType(String userType) {
			this.userType = userType;
			return this;
		}

		public UserDTO build() {
			return new UserDTO(this);
		}
	}

}