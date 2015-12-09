package com.yash.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "leave_request")
public class LeaveRequest {

	@Id
	@GeneratedValue
	@Column(name = "req_id")
	private Integer requestId;

	@Column(name = "today_date")
	private Date todayDate;

	@Column(name = "from_date")
	//@NotEmpty
	/*@Future*/
	private Date fromDate;

	@Column(name = "to_date")
//	@NotEmpty
	/*@Future*/
	private Date toDate;

//	@NotEmpty
	private Integer days;

	/*@NotNull
	@NotEmpty*/
	private String reason;

	private String message;

	@Column(name = "leave_type")
	/*@NotEmpty*/
	private String leaveTypes;

	@Column(name = "leave_status", nullable = false)
	private String leaveStatus;

	@ManyToOne
	@JoinColumn(name = "id")
	private Employee employee;

	public Integer getRequestId() {
		return requestId;
	}

	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	public Date getTodayDate() {
		return todayDate;
	}

	public void setTodayDate(Date todayDate) {
		this.todayDate = todayDate;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getLeaveTypes() {
		return leaveTypes;
	}

	public void setLeaveTypes(String leaveTypes) {
		this.leaveTypes = leaveTypes;
	}

	public String getLeaveStatus() {
		return (this.leaveStatus == null) ? "Pending" : leaveStatus;
	}

	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
