package bank.application.bankapplication.dto;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import bank.application.bankapplication.validate.Age;

public class CustomerDto {

	@NotEmpty(message = "First Name can not be Empty")
	private String firstName;

	private String lastName;

	@NotNull(message = "Gender can not be null")
	private String gender;

	@Past
	@Temporal(TemporalType.DATE)
	@Age(min = 18, message = "Age must be greater than or equal to 18.")
	private Date dob;

	@Id
	@Size(min = 10, max = 10, message = "Phone number length should be 10")
	private String phone;

	@Email
	private String email;

	public CustomerDto() {
	}

	public CustomerDto(String firstName, String lastName, String gender, Date dob, String phone, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.phone = phone;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
