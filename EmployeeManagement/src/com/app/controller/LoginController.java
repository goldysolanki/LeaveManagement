package com.app.controller;

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

import com.app.entity.User;

@Controller
public class LoginController {
	@Autowired
	private SessionFactory sessionFactory;

	@RequestMapping(value = "/login")
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new User());
		return mav;
	}

	@RequestMapping(value = "/checkLogin")
	public String checkLoginMethod(@ModelAttribute("user") User user,
			HttpSession session, Model model,
			@RequestParam("userId") String userId,
			@RequestParam("password") String password) {
		Session s = sessionFactory.openSession();
		Query q = s
				.createQuery("select userId,password,type from User where userId=? and password=?");
		q.setString(0, userId);
		q.setString(1, password);
		List<Object[]> list = q.list();
		for (Object[] obj : list) {
			System.out.println(obj[0] + " " + obj[1]);
			if (obj[0].equals(user.getUserId())
					&& obj[1].equals(user.getPassword())
					&& obj[2].equals("ADMIN")) {
				session.setAttribute("userId", user.getUserId());
				return "redirect:/get_all_emps";
			} else if (obj[0].equals(user.getUserId())
					&& obj[1].equals(user.getPassword())
					&& obj[2].equals("EMP")) {
				session.setAttribute("userId", user.getUserId());
				return "redirect:/show_details";
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

	@RequestMapping(value = "/invalidUser")
	public void invalidUserPage() {

	}

}
