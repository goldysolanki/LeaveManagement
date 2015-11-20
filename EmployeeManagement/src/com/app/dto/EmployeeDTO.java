package com.app.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class EmployeeDTO implements Comparable<EmployeeDTO> {

	@Override
	public int compareTo(EmployeeDTO emp) {
		return empName.compareTo(emp.getEmpName());
	}

	@NotNull
	@Min(1)
	@Max(100)
	private Integer empId;
	
	@NotEmpty
	private String empName;
	
	@NotEmpty
	private String userId;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String repeatPassword;
	
	@NotNull
	private Integer age;
	
	@NotEmpty
	private String email;
	
	@NotNull
	private Long phone;

	private AddressDTO address;

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

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
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

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [empId=" + empId + ", empName=" + empName
				+ ", age=" + age + ", email=" + email + ", phone=" + phone
				+ ", address=" + address + "]";
	}

}
