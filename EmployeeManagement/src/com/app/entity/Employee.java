package com.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name = "emp_id")
	private Integer empId;

	@Column(name = "emp_name")
	private String empName;

	@Column(name = "id")
	private String userId;

	@Column(name = "pswrd")
	private String password;

	@Column(name = "age")
	private Integer age;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private Long phone;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "address_id")
	private Address address;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", userId=" + userId + ", password=" + password + ", age="
				+ age + ", email=" + email + ", phone=" + phone + ", address="
				+ address + "]";
	}

}
