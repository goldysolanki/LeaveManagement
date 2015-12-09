package com.yash.service;

import java.util.List;

import com.yash.model.Employee;
import com.yash.model.LeaveRequest;

public interface LeaveRequestService {

	LeaveRequest add(LeaveRequest leave);

	LeaveRequest modify(LeaveRequest leave);

	void remove(Integer requestId);

	List<LeaveRequest> getAllLeaves();

	LeaveRequest getLeaveById(Integer requestId);

	List<LeaveRequest> findApprovedLeaves();

	List<LeaveRequest> findRejectedLeaves();

	Employee getEmployeeById(Integer empId);
}
