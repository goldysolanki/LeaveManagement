package com.app.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.AddressDTO;
import com.app.dto.EmployeeDTO;
import com.app.entity.Address;
import com.app.entity.Employee;
import com.app.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empDao;

	@Override
	public void add(EmployeeDTO empDTO) {
		Employee emp = new Employee();
		Address add = new Address();
		emp.setEmpName(empDTO.getEmpName());
		emp.setUserId(empDTO.getUserId());
		emp.setPassword(empDTO.getPassword());
		emp.setAge(empDTO.getAge());
		emp.setEmail(empDTO.getEmail());
		emp.setPhone(empDTO.getPhone());
		add.setStreet(empDTO.getAddress().getStreet());
		add.setLocation(empDTO.getAddress().getLocation());
		add.setCity(empDTO.getAddress().getCity());
		emp.setAddress(add);
		empDao.save(emp);
	}

	@Override
	public void modify(EmployeeDTO empDTO) {
		Employee emp = new Employee();
		Address add = new Address();
		emp.setEmpId(empDTO.getEmpId());
		emp.setEmpName(empDTO.getEmpName());
		emp.setAge(empDTO.getAge());
		emp.setEmail(empDTO.getEmail());
		emp.setPhone(empDTO.getPhone());
		add.setAddressId(empDTO.getAddress().getAddressId());
		add.setStreet(empDTO.getAddress().getStreet());
		add.setLocation(empDTO.getAddress().getLocation());
		add.setCity(empDTO.getAddress().getCity());
		emp.setAddress(add);
		empDao.update(emp);
	}

	@Override
	public void remove(Integer empIdDTO) {
		empDao.delete(empIdDTO);
	}

	@Override
	public EmployeeDTO searchById(Integer empIdDTO) {
		EmployeeDTO empDTO = null;
		AddressDTO addDTO = null;
		Employee emp = empDao.findById(empIdDTO);
		if (emp != null) {
			empDTO = new EmployeeDTO();
			addDTO = new AddressDTO();
			empDTO.setEmpId(emp.getEmpId());
			empDTO.setEmpName(emp.getEmpName());
			empDTO.setAge(emp.getAge());
			empDTO.setEmail(emp.getEmail());
			empDTO.setPhone(emp.getPhone());
			addDTO.setAddressId(emp.getAddress().getAddressId());
			addDTO.setStreet(emp.getAddress().getStreet());
			addDTO.setLocation(emp.getAddress().getLocation());
			addDTO.setCity(emp.getAddress().getCity());
			empDTO.setAddress(addDTO);
		}
		return empDTO;
	}

	@Override
	public EmployeeDTO searchByUserId(String userId) {
		EmployeeDTO empDTO = null;
		AddressDTO addDTO = null;
		Employee emp = empDao.findByUserId(userId);
		if (emp != null) {
			empDTO = new EmployeeDTO();
			addDTO = new AddressDTO();
			empDTO.setEmpId(emp.getEmpId());
			empDTO.setEmpName(emp.getEmpName());
			empDTO.setUserId(emp.getUserId());
			empDTO.setAge(emp.getAge());
			empDTO.setEmail(emp.getEmail());
			empDTO.setPhone(emp.getPhone());
			addDTO.setAddressId(emp.getAddress().getAddressId());
			addDTO.setStreet(emp.getAddress().getStreet());
			addDTO.setLocation(emp.getAddress().getLocation());
			addDTO.setCity(emp.getAddress().getCity());
			empDTO.setAddress(addDTO);
		}
		return empDTO;
	}

	@Override
	public List<EmployeeDTO> loadAllEmployees() {
		List<EmployeeDTO> empDTOList = new ArrayList<EmployeeDTO>();
		List<Employee> empList = empDao.getAllEmployees();
		if (empList != null && !empList.isEmpty()) {
			for (Employee emp : empList) {
				EmployeeDTO empDTO = new EmployeeDTO();
				AddressDTO addDTO = new AddressDTO();
				empDTO.setEmpId(emp.getEmpId());
				empDTO.setEmpName(emp.getEmpName());
				empDTO.setAge(emp.getAge());
				empDTO.setEmail(emp.getEmail());
				empDTO.setPhone(emp.getPhone());
				addDTO.setAddressId(emp.getAddress().getAddressId());
				addDTO.setStreet(emp.getAddress().getStreet());
				addDTO.setLocation(emp.getAddress().getLocation());
				addDTO.setCity(emp.getAddress().getCity());
				empDTO.setAddress(addDTO);
				empDTOList.add(empDTO);
			}
		}
		Collections.sort(empDTOList);
		return empDTOList;
	}
}
