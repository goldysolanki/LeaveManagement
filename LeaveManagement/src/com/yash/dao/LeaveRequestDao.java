package com.yash.dao;

import java.util.List;

import com.yash.model.Employee;
import com.yash.model.LeaveRequest;

public interface LeaveRequestDao {

	void save(LeaveRequest leave);

	List<LeaveRequest> loadAllLeaves();

	void update(LeaveRequest leave);

	void delete(Integer requestId);

	LeaveRequest loadLeaveById(Integer requestId);
	
	List<LeaveRequest> getApprovedLeaves();
	
	List<LeaveRequest> getRejectedLeaves();
	
	Employee loadEmployeeById(Integer empId);
}
