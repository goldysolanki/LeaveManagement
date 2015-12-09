package com.yash.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yash.model.Employee;

@Controller
public class LoginController {
	@Autowired
	private SessionFactory sessionFactory;

	@RequestMapping(value = { "/", "/login" })
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("employee", new Employee());
		return mav;
	}

	@RequestMapping(value = "/checkLogin")
	public String checkLoginMethod(@ModelAttribute("employee") Employee emp,
			HttpSession session, Model model,
			@RequestParam("userName") String userName,
			@RequestParam("password") String password) {
		Session s = sessionFactory.openSession();
		Query q = s
				.createQuery("select userName,password,id from Employee where userName=? and password=?");
		q.setString(0, userName);
		q.setString(1, password);
		List<Object[]> list = q.list();
		for (Object[] obj : list) {
			System.out.println(obj[0] + " " + obj[1] + " " + obj[2]);
			if (obj[0].equals(emp.getUserName())
					&& obj[1].equals(emp.getPassword())) {
				session.setAttribute("id", obj[2]);
				return "redirect:/show";
			}
		}
		model.addAttribute("error", "Invalid Id/Password");
		return "login";
	}

	@RequestMapping(value = "/logout")
	public String logoutMethod(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

	@RequestMapping(value = "/invalidEmployee")
	public String invalidEmployeePage() {
		return "invalidEmployee";
	}

}
