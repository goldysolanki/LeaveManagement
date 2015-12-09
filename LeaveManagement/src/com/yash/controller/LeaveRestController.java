package com.yash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yash.model.Employee;
import com.yash.model.LeaveRequest;
import com.yash.service.LeaveRequestService;

@RestController
@RequestMapping("/rest")
public class LeaveRestController {

	@Autowired
	private LeaveRequestService service;

	/*
	 * @RequestMapping(value = { "/", "/hello" }) public @ResponseBody
	 * ModelAndView showPage() { ModelAndView mav = new
	 * ModelAndView("LeaveForm"); mav.addObject("employee", new Employee());
	 * return mav; }
	 */

	@RequestMapping(value = "/post", method = RequestMethod.POST, produces = "application/json", consumes = "application/json", headers = "Accept=*")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public LeaveRequest createLeave(@RequestBody LeaveRequest leaveRequest) {
		LeaveRequest leave = service.add(leaveRequest);
		/*
		 * String message = "Your request has been saved. Your request ID is " +
		 * leave.getRequestId();
		 */
		return leave;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET, headers = "Accept=*", produces = "application/json")
	@ResponseBody
	public List<LeaveRequest> findAllLeaves() {
		return service.getAllLeaves();
	}

	@RequestMapping(value = "/getEmployeeById/{empId}", method = RequestMethod.GET, headers = "Accept=*", produces = "application/json")
	@ResponseBody
	public Employee findEmployeeById(@PathVariable("empId") Integer empId) {
		return service.getEmployeeById(empId);
	}

	@RequestMapping(value = "/get/approved", method = RequestMethod.GET, headers = "Accept=*", produces = "application/json")
	@ResponseBody
	public List<LeaveRequest> findApprovedLeaves() {
		return service.findApprovedLeaves();
	}

	@RequestMapping(value = "/get/rejected", method = RequestMethod.GET, headers = "Accept=*", produces = "application/json")
	@ResponseBody
	public List<LeaveRequest> findRejectedLeaves() {
		return service.findRejectedLeaves();
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, headers = "Accept=*", produces = "application/json")
	@ResponseBody
	public LeaveRequest findLeaveById(@PathVariable("id") Integer id) {
		return service.getLeaveById(id);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, headers = "Accept=*", consumes = "application/json")
	@ResponseBody
	public String delete(@PathVariable("id") Integer id) {
		service.remove(id);
		return "Request ID " + id + " has been deleted";
	}

	@RequestMapping(value = "/put", method = RequestMethod.PUT, consumes = "application/json", headers = "Accept=*", produces = "application/json")
	@ResponseBody
	public String update(@RequestBody LeaveRequest leaveRequest) {
		service.modify(leaveRequest);
		return "success";
	}

	/*
	 * @RequestMapping(value = "/save/{name}/{value}", method =
	 * RequestMethod.GET, produces = "application/json") public @ResponseBody
	 * Employee showEmployeePageNew(
	 * 
	 * @PathVariable("name") String name,@PathVariable("value") int age) {
	 * Employee emp = new Employee(name,age);
	 * 
	 * return emp; }
	 */

}
