package com.app.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.dto.EmployeeDTO;

public class CustomValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return EmployeeDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		EmployeeDTO empDTO = (EmployeeDTO) target;
		if (empDTO.getEmpName() == null) {
			errors.rejectValue("empName", "required.employee.empName",
					"Employee Name can't be empty");
		} else if (empDTO.getEmpName() != null
				&& (empDTO.getEmpName().contains("0")
						|| empDTO.getEmpName().contains("1")
						|| empDTO.getEmpName().contains("2")
						|| empDTO.getEmpName().contains("3")
						|| empDTO.getEmpName().contains("4")
						|| empDTO.getEmpName().contains("5")
						|| empDTO.getEmpName().contains("6")
						|| empDTO.getEmpName().contains("7")
						|| empDTO.getEmpName().contains("8") || empDTO
						.getEmpName().contains("9"))) {
			errors.rejectValue("empName", "invalid.employee.empName",
					"Employee Name is incorrect");
		} else if (empDTO.getUserId() == null) {
			errors.rejectValue("userId", "required.employee.userId",
					"User ID can't be empty");
		} else if (empDTO.getPassword() == null) {
			errors.rejectValue("password", "required.employee.password",
					"Password can't be empty");
		} else if (empDTO.getRepeatPassword() == null) {
			errors.rejectValue("repeatPassword",
					"required.employee.repeatPassword",
					"Same Password must be repeated");
		} else if (!empDTO.getPassword().equals(empDTO.getRepeatPassword())) {
			errors.rejectValue("repeatPassword", "NotMatch.employee.password",
					"Both Passwords must be the same");
		} else if (empDTO.getAge() == null) {
			errors.rejectValue("age", "required.employee.age",
					"Age can't be empty");
		} else if (empDTO.getAge() != null && empDTO.getAge() <= 0) {
			errors.rejectValue("age", "negative.employee.age",
					"Age can't be negative");
		} else if (empDTO.getEmail() == null) {
			errors.rejectValue("email", "required.employee.email",
					"Email can't be empty");
		} else if (empDTO.getEmail() != null
				&& !empDTO.getEmail().contains("@")) {
			errors.rejectValue("email", "invalid.employee.email",
					"Not a valid email");
		} else if (empDTO.getPhone() == null) {
			errors.rejectValue("phone", "required.employee.phone",
					"Phone No. can't be empty");
		} else if (empDTO.getPhone() != null && empDTO.getPhone() <= 0) {
			errors.rejectValue("phone", "negative.employee.phone",
					"Phone No. can't be negative");
		} else if (empDTO.getAddress().getStreet() == null) {
			errors.rejectValue("address.street", "required.employee.street",
					"Street can't be empty");
		} /*
		 * else if (empDTO.getAddress().getStreet() != null &&
		 * (empDTO.getAddress().getStreet().contains("0") ||
		 * empDTO.getAddress().getStreet().contains("1") ||
		 * empDTO.getAddress().getStreet().contains("2") ||
		 * empDTO.getAddress().getStreet().contains("3") ||
		 * empDTO.getAddress().getStreet().contains("4") ||
		 * empDTO.getAddress().getStreet().contains("5") ||
		 * empDTO.getAddress().getStreet().contains("6") ||
		 * empDTO.getAddress().getStreet().contains("7") ||
		 * empDTO.getAddress().getStreet().contains("8") || empDTO
		 * .getAddress().getStreet().contains("9"))) {
		 * errors.rejectValue("street", "invalid.employee.street",
		 * "Street is not correct"); }
		 */else if (empDTO.getAddress().getLocation() == null) {
			errors.rejectValue("address.location",
					"required.employee.location", "Location can't be empty");
		} else if (empDTO.getAddress().getCity() == null) {
			errors.rejectValue("address.city", "required.employee.city",
					"City can't be empty");
		}
	}

}
