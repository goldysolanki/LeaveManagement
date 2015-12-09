package com.app.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.cfg.Configuration;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.entity.Address;
import com.app.entity.Employee;
import com.app.entity.User;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
	@Autowired
	private SessionFactory sessionFactory;;

	@Override
	public void delete(Integer empId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee emp = (Employee) session.get(Employee.class, empId);
		session.delete(emp);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Employee findById(Integer empId) {
		Session session = sessionFactory.openSession();
		Employee emp = (Employee) session.get(Employee.class, empId);
		session.close();
		return emp;
	}

	@Override
	public Employee findByUserId(String userId) {
		Session session = sessionFactory.openSession();
		Criteria crt = session.createCriteria(Employee.class);
		crt.add(Restrictions.eq("userId", userId));
		Employee emp = (Employee) crt.uniqueResult();
		session.close();
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		Session session = sessionFactory.openSession();
		Criteria crt = session.createCriteria(Employee.class);
		List<Employee> list = crt.list();
		session.close();
		return list;
	}

	@Override
	public void save(Employee emp) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	public void saveUser(Employee emp) {
		Session session = sessionFactory.openSession();
		SQLQuery q = session
				.createSQLQuery("select id,pswrd from employee where id=? ;");
		q.setString(0, emp.getUserId());
		q.addEntity(Employee.class);
		List<Object[]> list = q.list();
		for (Object[] obj : list) {
			System.out.println(obj[0] + " " + obj[1]);
			session.beginTransaction();
			SQLQuery query = session
					.createSQLQuery("insert into user (user_id,password) values ("
							+ obj[0] + "," + obj[1] + ")");
			query.addEntity(User.class);
			query.executeUpdate();
			session.getTransaction().commit();
			session.close();
		}

	}

	@Override
	public void update(Employee emp) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(emp);
		session.getTransaction().commit();
		session.close();
	}

	private List<Employee> prepareList(List list) {
		List<Employee> employees = new ArrayList<Employee>();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Employee employee = new Employee();
			employee = (Employee) iterator.next();
			employees.add(employee);
		}

		return employees;
	}

}
