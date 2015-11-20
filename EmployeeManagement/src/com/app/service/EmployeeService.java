package com.app.service;

import java.util.List;

import com.app.dto.EmployeeDTO;

public interface EmployeeService {

	public void add(EmployeeDTO empDTO);

	public void modify(EmployeeDTO empDTO);

	public void remove(Integer empIdDTO);

	public EmployeeDTO searchById(Integer empIdDTO);

	public List<EmployeeDTO> loadAllEmployees();

	public EmployeeDTO searchByUserId(String userId);
}
