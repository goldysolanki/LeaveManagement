package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.EmployeeDTO;
import com.app.service.EmployeeService;

@Controller
public class AdminController {
	@Autowired
	private EmployeeService empService;
	@Autowired
	private Validator validator;

	@RequestMapping(value = "/show")
	public ModelAndView showUserPage() {
		ModelAndView mav = new ModelAndView("input");
		mav.addObject("employee", new EmployeeDTO());
		return mav;
	}

	@RequestMapping(value = "/save")
	public String saveUser(@ModelAttribute("employee") EmployeeDTO employee,
			BindingResult result) {
		System.out.println(employee);
		validator.validate(employee, result);
		if (result.hasErrors()) {
			return "input";
		}
		empService.add(employee);
		return "redirect:/get_all_emps";
	}

	@RequestMapping(value = "/show_details")
	public ModelAndView showUser(HttpSession session) {
		ModelAndView mav = new ModelAndView("showUser");
		String userId = (String) session.getAttribute("userId");
		mav.addObject("userId", userId);
		mav.addObject("employee", empService.searchByUserId(userId));
		return mav;
	}

	@RequestMapping(value = "/get_all_emps")
	public ModelAndView displayUsers(HttpSession session) {
		ModelAndView mav = new ModelAndView("success");
		String userId = (String) session.getAttribute("userId");
		mav.addObject("userId", userId);
		mav.addObject("empsList", empService.loadAllEmployees());
		return mav;
	}

	@RequestMapping(value = "/edit")
	public ModelAndView editUser(@RequestParam("empId") Integer empId) {
		ModelAndView mav = new ModelAndView("edit");
		mav.addObject("employee", empService.searchById(empId));
		return mav;
	}

	@RequestMapping(value = "/update")
	public String updateUser(@ModelAttribute("employee") EmployeeDTO employee,
			BindingResult result) {
		System.out.println(employee);
		validator.validate(employee, result);
		if (result.hasErrors()) {
			return "edit";
		}
		empService.modify(employee);
		return "redirect:/get_all_emps";
	}

	@RequestMapping(value = "/delete")
	public String deleteUser(@RequestParam("empId") Integer empId) {
		empService.remove(empId);
		return "redirect:/get_all_emps";
	}

	@InitBinder
	public void bindingOperation(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

}
