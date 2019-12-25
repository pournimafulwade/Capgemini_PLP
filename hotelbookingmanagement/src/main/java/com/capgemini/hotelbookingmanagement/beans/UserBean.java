package com.capgemini.hotelbookingmanagement.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "user_registration")
public class UserBean {
	@Id
	@Column
	private int userId;
	@Column
	@Pattern(regexp = "\\w+\\s\\w+")
	@NotEmpty(message = "first name must not be empty")
//	@NotBlank(message = "Name cannot be Empty!!")
	private String userName;
	@Column
//	@Pattern(regexp = "\\w+\\@\\w+\\.\\w+")
    @NotEmpty(message = "email must not be empty")
    @Email(message = "email should be a valid email")
	private String userEmail;
	@Column
	@Pattern(regexp = "([a-z])(?=.*[A-Z]).{4,10}")
	private String userPassword;
	@Column
	@Pattern(regexp = "[6-9]{1}[0-9]{9}", message = "mobile number should of 10 digits!!")
	private String mobile;
	@Column
	@NotBlank(message = "Address cannot be Empty!!")
	private String address;
	@Column
	@NotBlank(message = "Nationality should not be empty!!")
	private String nationality;
	@Column
	@NotBlank(message = "User Type should not be empty!!")
	private String userType;
	@Column
//	@Pattern(regexp = "\\d{1,10}")
	private int hotelId;

	// getters and setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
}// end of the UserBean class
