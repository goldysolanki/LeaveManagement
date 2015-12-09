package com.yash.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.yash.model.Employee;
import com.yash.model.LeaveRequest;
import com.yash.model.LeaveTypes;

@Controller
public class LeaveController {

	@Autowired
	@Qualifier(value = "validator")
	private Validator validator;

	private RestTemplate restTemplate;

	@RequestMapping(value = "/show")
	public ModelAndView showPage(HttpSession session) {
		ModelAndView mav = new ModelAndView("LeaveForm");
		Integer empId = (Integer) session.getAttribute("id");
		System.out.println("-------------------" + empId);
		restTemplate = new RestTemplate();
		String url = "http://localhost:8080/LeaveManagement/rest/getEmployeeById/"
				+ empId;
		Employee emp = restTemplate.getForObject(url, Employee.class);
		mav.addObject("emp", emp);
		mav.addObject("leaveRequest", new LeaveRequest());
		return mav;
	}

	@RequestMapping(value = "/save")
	public String saveMethod(
			@Valid @ModelAttribute("leaveRequest") LeaveRequest leaveRequest,
			ModelMap map, BindingResult result) {
		validator.validate(leaveRequest, result);
		if (result.hasErrors()) {
			return "LeaveForm";
		}
		restTemplate = new RestTemplate();
		String url = "http://localhost:8080/LeaveManagement/rest/post";
		LeaveRequest leave = restTemplate.postForObject(url, leaveRequest,
				LeaveRequest.class);
		leave.setMessage("Thank you for applying with Leave Management. Your Request for Leave has been generated. Your request ID is "
				+ leave.getRequestId());
		map.addAttribute("message", leave.getMessage());
		return "success";
	}

	@RequestMapping("/get_list")
	public String getList(ModelMap map) {
		String url = "http://localhost:8080/LeaveManagement/rest/get";
		List list = restTemplate.getForObject(url, List.class);
		map.addAttribute("leaves", list);
		return "leavesList";
	}

	@RequestMapping("/get_approved_list")
	public String getApprovedList(ModelMap map) {
		String url = "http://localhost:8080/LeaveManagement/rest/get/approved";
		List list = restTemplate.getForObject(url, List.class);
		map.addAttribute("leaves", list);
		return "leavesList";
	}

	@RequestMapping("/get_rejected_list")
	public String getRejectedList(ModelMap map) {
		String url = "http://localhost:8080/LeaveManagement/rest/get/rejected";
		List list = restTemplate.getForObject(url, List.class);
		map.addAttribute("leaves", list);
		return "leavesList";
	}

	@RequestMapping("/edit")
	public String editLeaveRequest(@RequestParam("requestId") Integer reqId,
			ModelMap map) {
		String url = "http://localhost:8080/LeaveManagement/rest/get/" + reqId;
		LeaveRequest leave = restTemplate.getForObject(url, LeaveRequest.class);
		map.addAttribute("updateLeave", leave);
		return "editList";
	}

	@RequestMapping("/update")
	public String updateLeaveRequest(
			@ModelAttribute("updateLeave") LeaveRequest leaveRequest) {
		String url = "http://localhost:8080/LeaveManagement/rest/put";
		restTemplate.put(url, leaveRequest);
		return "redirect:/get_list";
	}

	@ModelAttribute("leaveTypes")
	public List<LeaveTypes> getAllTypes() {
		List<LeaveTypes> list = new ArrayList<LeaveTypes>();
		list.add(new LeaveTypes("CL", "Casual Leave"));
		list.add(new LeaveTypes("PL", "Paid Leave"));
		list.add(new LeaveTypes("SL", "Sick Leave"));
		list.add(new LeaveTypes("EL", "Earned Leave"));
		list.add(new LeaveTypes("BL", "Birthday Leave"));
		list.add(new LeaveTypes("AL", "Anniversary Leave"));
		list.add(new LeaveTypes("ML", "Maternity Leave"));
		return list;
	}

	@ModelAttribute("leaveStatus")
	public List<String> getAllStatus() {
		List<String> list = new ArrayList<String>();
		list.add("Approved");
		list.add("Rejected");
		list.add("Pending");
		return list;

	}

	private static final String dateFormat = "dd-MM-yyyy";

	@InitBinder
	public void bindingOperation(WebDataBinder binder) {
		binder.setValidator(validator);
		DateFormat df = new SimpleDateFormat(dateFormat);
		df.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));
	}
}
