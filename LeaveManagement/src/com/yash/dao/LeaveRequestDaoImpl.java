package com.yash.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.model.Employee;
import com.yash.model.LeaveRequest;

@Repository
public class LeaveRequestDaoImpl implements LeaveRequestDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(LeaveRequest leave) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(leave);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void update(LeaveRequest leave) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(leave);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void delete(Integer requestId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		LeaveRequest leave = (LeaveRequest) session.get(LeaveRequest.class,
				requestId);
		session.delete(leave);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public List<LeaveRequest> loadAllLeaves() {
		Session session = sessionFactory.openSession();
		Criteria crt = session.createCriteria(LeaveRequest.class);
		List<LeaveRequest> leaves = crt.list();
		session.close();
		return leaves;
	}

	@Override
	public List<LeaveRequest> getApprovedLeaves() {
		Session session = sessionFactory.openSession();
		Criteria crt = session.createCriteria(LeaveRequest.class);
		crt.add(Restrictions.eq("leaveStatus", "Approved"));
		List<LeaveRequest> leaves = crt.list();
		session.close();
		return leaves;
	}

	@Override
	public List<LeaveRequest> getRejectedLeaves() {
		Session session = sessionFactory.openSession();
		Criteria crt = session.createCriteria(LeaveRequest.class);
		crt.add(Restrictions.eq("leaveStatus", "Rejected"));
		List<LeaveRequest> leaves = crt.list();
		session.close();
		return leaves;
	}

	@Override
	public LeaveRequest loadLeaveById(Integer requestId) {
		Session session = sessionFactory.openSession();
		LeaveRequest leave = (LeaveRequest) session.get(LeaveRequest.class,
				requestId);
		session.close();
		return leave;
	}

	@Override
	public Employee loadEmployeeById(Integer empId) {
		Session session = sessionFactory.openSession();
		Employee emp = (Employee) session.get(Employee.class, empId);
		session.close();
		return emp;
	}

	/*
	 * private LeaveRequestDto convertToDTO(LeaveRequest leaveRequest) {
	 * LeaveRequestDto leaveRequestDto = new LeaveRequestDto();
	 * leaveRequestDto.setRequestId(leaveRequest.getRequestId());
	 * leaveRequestDto.setTodayDate(leaveRequest.getTodayDate());
	 * leaveRequestDto.setFromDate(leaveRequest.getFromDate());
	 * leaveRequestDto.setToDate(leaveRequest.getToDate());
	 * leaveRequestDto.setDays(leaveRequest.getDays());
	 * leaveRequestDto.setReason(leaveRequest.getReason());
	 * leaveRequestDto.setLeaveType(leaveRequest.getLeaveType());
	 * leaveRequestDto.setLeaveStatus(leaveRequest.getLeaveStatus()); return
	 * leaveRequestDto; }
	 */
}
