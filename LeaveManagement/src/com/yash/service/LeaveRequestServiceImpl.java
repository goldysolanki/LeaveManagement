package com.yash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dao.LeaveRequestDao;
import com.yash.model.Employee;
import com.yash.model.LeaveRequest;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

	@Autowired
	private LeaveRequestDao dao;

	@Override
	public LeaveRequest add(LeaveRequest leave) {
		dao.save(leave);
		return leave;
	}

	@Override
	public LeaveRequest modify(LeaveRequest leave) {
		dao.update(leave);
		return leave;
	}

	@Override
	public void remove(Integer requestId) {
		dao.delete(requestId);
	}

	@Override
	public List<LeaveRequest> getAllLeaves() {
		List<LeaveRequest> list = dao.loadAllLeaves();
		return list;
	}

	@Override
	public List<LeaveRequest> findApprovedLeaves() {
		return dao.getApprovedLeaves();
	}

	@Override
	public List<LeaveRequest> findRejectedLeaves() {
		return dao.getRejectedLeaves();
	}

	@Override
	public Employee getEmployeeById(Integer empId) {
		return dao.loadEmployeeById(empId);
	}

	@Override
	public LeaveRequest getLeaveById(Integer requestId) {
		LeaveRequest leave = dao.loadLeaveById(requestId);
		return leave;
	}
}
