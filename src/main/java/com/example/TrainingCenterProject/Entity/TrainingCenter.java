package com.example.TrainingCenterProject.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class TrainingCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 40, nullable = false)
    @Size(max = 40, message = "Center name must be less than 40 characters")
    @NotBlank(message = "Center name is required")
	private String centerName;
	
	@Column(length = 12, unique = true, nullable = false)
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center code must be exactly 12 alphanumeric characters")
    @NotBlank(message = "Center code is required")
	private String centerCode;
	private int studentCapacity;
	private List<String> coursesOffered;
	private long createdOn;
	
	@Email(message = "Invalid email format")
	private String contactEmail;
	
	@Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
	@NotBlank(message = "Contact phone is required")
	private String contactPhone;
	
	@Embedded
	private Address address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getCenterCode() {
		return centerCode;
	}
	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}
	public int getStudentCapacity() {
		return studentCapacity;
	}
	public void setStudentCapacity(int studentCapacity) {
		this.studentCapacity = studentCapacity;
	}
	public List<String> getCoursesOffered() {
		return coursesOffered;
	}
	public void setCoursesOffered(List<String> coursesOffered) {
		this.coursesOffered = coursesOffered;
	}
	public long getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(long createdOn) {
		this.createdOn = createdOn;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public TrainingCenter(int id, String centerName, String centerCode, int studentCapacity,
			List<String> coursesOffered, long createdOn, String contactEmail, String contactPhone, Address address) {
		super();
		this.id = id;
		this.centerName = centerName;
		this.centerCode = centerCode;
		this.studentCapacity = studentCapacity;
		this.coursesOffered = coursesOffered;
		this.createdOn = createdOn;
		this.contactEmail = contactEmail;
		this.contactPhone = contactPhone;
		this.address = address;
	}
	public TrainingCenter() {
		super();
	}
	@Override
	public String toString() {
		return "TrainingCenter [id=" + id + ", centerName=" + centerName + ", centerCode=" + centerCode
				+ ", studentCapacity=" + studentCapacity + ", coursesOffered=" + coursesOffered + ", createdOn="
				+ createdOn + ", contactEmail=" + contactEmail + ", contactPhone=" + contactPhone + ", address="
				+ address + "]";
	}
	
	
	
}
