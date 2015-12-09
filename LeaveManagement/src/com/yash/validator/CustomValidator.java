package com.yash.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.yash.model.LeaveRequest;

public class CustomValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return LeaveRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		LeaveRequest leave = (LeaveRequest) target;
		if (leave.getFromDate() == null) {
			errors.rejectValue("fromDate", "required.leave.fromDate",
					"From Date can't be empty");
		} else if (leave.getToDate() == null) {
			errors.rejectValue("toDate", "required.leave.toDate",
					"To Date can't be empty");
		} else if (leave.getDays() == null) {
			errors.rejectValue("days", "required.leave.days",
					"Days can't be empty");
		} else if (leave.getReason() == null) {
			errors.rejectValue("reason", "required.leave.reason",
					"Reason can't be empty");
		} else if (leave.getLeaveTypes() == null) {
			errors.rejectValue("leaveTypes", "required.leave.leaveTypes",
					"Leave Type can't be empty");
		}
	}
}
