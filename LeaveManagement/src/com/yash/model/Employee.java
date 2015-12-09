package com.yash.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "employee")
@JsonInclude(value = Include.NON_NULL)
public class Employee {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "PHONE")
	private Integer phone;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "ROLE_ID") private Roles roles;
	 */

	/*
	 * @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL) private
	 * Set<LeaveRequest> leaveRequests;
	 */

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	/*
	 * public Roles getRoles() { return roles; }
	 * 
	 * public void setRoles(Roles roles) { this.roles = roles; }
	 */

	/*
	 * public Set<LeaveRequest> getLeaveRequests() { return leaveRequests; }
	 * 
	 * public void setLeaveRequests(Set<LeaveRequest> leaveRequests) {
	 * this.leaveRequests = leaveRequests; }
	 */

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", userName=" + userName + ", password="
				+ password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", address=" + address + ", email=" + email
				+ ", status=" + status + ", phone=" + phone + "]";
	}

}
