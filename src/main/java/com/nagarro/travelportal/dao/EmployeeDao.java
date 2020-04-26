package com.nagarro.travelportal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.travelportal.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, String>{
//get employee by email address.
}
