package com.app.repository;

import java.util.List;

import com.app.entity.Employee;

public interface EmployeeRepository {

	public void save(Employee emp);

	public void update(Employee emp);

	public void delete(Integer empId);

	public Employee findById(Integer empId);

	public List<Employee> getAllEmployees();

	public Employee findByUserId(String userId);

	public void saveUser(Employee emp);
}
