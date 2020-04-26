package com.nagarro.travelportal.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
	public Employee addEmployee(Employee employee) {
		return empdao.save(employee);
	}
	
	/**
	 * Gets the employee by username.
	 *
	 * @return the employee by username
	 */
	public Employee getEmployeeByUsername(String username)throws NoSuchElementException{
		return empdao.findById(username).get();
	}
	
	/**
	 * Gets the all employee.
	 *
	 * @return the all employee
	 */
	public List<Employee> getAllEmployee(){
		return empdao.findAll();
	}
}
