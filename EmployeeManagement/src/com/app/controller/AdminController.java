package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.EmployeeDTO;
import com.app.service.EmployeeService;

@Path(value = "/methods")
public class AdminController {
	@Autowired
	private EmployeeService empService;

	/* private Validator validator; */

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMethod() {
		List<EmployeeDTO> list = empService.loadAllEmployees();
		CacheControl control = new CacheControl();
		control.setMaxAge(60);
		return Response.status(200).entity(list).cacheControl(control).build();
	}

	@POST
	@Path("/post")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveMethod(EmployeeDTO employee) {
		empService.add(employee);
		String string = "Record created successfully";
		return Response.status(201).entity(string).build();
	}

	@PUT
	@Path("/put")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMethod(EmployeeDTO employee) {
		empService.modify(employee);
		return Response.status(200).entity("Record updated successfully")
				.build();
	}

	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteMethod(EmployeeDTO employee) {
		empService.remove(employee.getEmpId());
		return Response.status(200).entity("Record deleted successfully")
				.build();

	}
	/*
	 * @RequestMapping(value = "/show") public ModelAndView showUserPage() {
	 * ModelAndView mav = new ModelAndView("input"); mav.addObject("employee",
	 * new EmployeeDTO()); return mav; }
	 * 
	 * @RequestMapping(value = "/save") public String
	 * saveUser(@ModelAttribute("employee") EmployeeDTO employee, BindingResult
	 * result) { System.out.println(employee); validator.validate(employee,
	 * result); if (result.hasErrors()) { return "input"; }
	 * empService.add(employee); return "redirect:/get_all_emps"; }
	 * 
	 * @RequestMapping(value = "/show_details") public ModelAndView
	 * showUser(HttpSession session) { ModelAndView mav = new
	 * ModelAndView("showUser"); String userId = (String)
	 * session.getAttribute("userId"); mav.addObject("userId", userId);
	 * mav.addObject("employee", empService.searchByUserId(userId)); return mav;
	 * }
	 * 
	 * @RequestMapping(value = "/get_all_emps") public ModelAndView
	 * displayUsers(HttpSession session) { ModelAndView mav = new
	 * ModelAndView("success"); String userId = (String)
	 * session.getAttribute("userId"); mav.addObject("userId", userId);
	 * mav.addObject("empsList", empService.loadAllEmployees()); return mav; }
	 * 
	 * @RequestMapping(value = "/edit/{empId}") public ModelAndView
	 * editUser(@PathVariable Integer empId) { ModelAndView mav = new
	 * ModelAndView("edit"); mav.addObject("employee",
	 * empService.searchById(empId)); return mav; }
	 * 
	 * @RequestMapping(value = "/update") public String
	 * updateUser(@ModelAttribute("employee") EmployeeDTO employee,
	 * BindingResult result) { System.out.println(employee);
	 * //validator.validate(employee, result); if (result.hasErrors()) { return
	 * "edit"; } empService.modify(employee); return "redirect:/get_all_emps"; }
	 * 
	 * @RequestMapping(value = "/delete") public String
	 * deleteUser(@RequestParam("empId") Integer empId) {
	 * empService.remove(empId); return "redirect:/get_all_emps"; }
	 * 
	 * @InitBinder public void bindingOperation(WebDataBinder binder) {
	 * binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	 * }
	 */

}
