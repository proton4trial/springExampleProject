package com.mayank.st.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mayank.st.entity.Employee;
import com.mayank.st.respository.EmpRepository;
import com.mayank.st.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService{

	private EmpRepository empRepository;
	
	public EmpServiceImpl(EmpRepository empRepository) {
		super();
		this.empRepository = empRepository;
	}


	@Override
	public List<Employee> getAllEmployee() {
		return empRepository.findAll();
	}



	@Override
	public Employee saveEmployee(Employee employee) {
		return empRepository.save(employee);
	}



	@Override
	public Employee getEmployeeID(Long employeeID) {
		return empRepository.findById(employeeID).get();
	}



	@Override
	public Employee updateEmployee(Employee employee) {
		return empRepository.save(employee);
	}



	@Override
	public void removeEmpById(Long employeeID) {
		empRepository.deleteById(employeeID);
		return;
	}


	
}
