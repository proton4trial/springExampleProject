package com.mayank.st.service;

import java.util.List;

import com.mayank.st.entity.Employee;

public interface EmpService {
	List<Employee> getAllEmployee();
	
	Employee saveEmployee(Employee employee);
	
	Employee getEmployeeID(Long employeeID);
	Employee updateEmployee(Employee employee);
	
	void removeEmpById(Long employeeID);
}
