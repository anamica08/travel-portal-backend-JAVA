package com.nagarro.travelportal.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.travelportal.dao.EmployeeDao;
import com.nagarro.travelportal.model.Employee;


@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao empdao;
	
	/**
	 * Adds the employee.
	 *
	 * @param employee the employee
	 */
	public void addEmployee(Employee employee) {
		empdao.save(employee);
	}
	
	/**
	 * Gets the employee by username.
	 *
	 * @return the employee by username
	 */
	public Employee getEmployeeByUsername(String username) {
		return empdao.findById(username).get();
	}
	
	public List<Employee> getAllEmployee(){
		return empdao.findAll();
	}
}
