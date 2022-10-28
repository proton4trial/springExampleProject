package com.mayank.st.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mayank.st.entity.Employee;
import com.mayank.st.service.EmpService;

@Controller
public class EmpController {
	private EmpService empService;

	public EmpController(EmpService empService) {
		super();
		this.empService = empService;
	}
	
	@GetMapping("/employees")
	public String listEmps(Model model) {
		model.addAttribute("employees", empService.getAllEmployee());
		return "employees";
	}
	
	@GetMapping("/employees/new")
	public String createEmpForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "createEmp";
	}
	
	@PostMapping("/employees")
	public String saveEmp(@ModelAttribute("employee") Employee employee) {
		empService.saveEmployee(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/edit/{employeeID}")
	public String editEmp (@PathVariable Long employeeID, Model model) {
		model.addAttribute("employee", empService.getEmployeeID(employeeID));
		return "editEmp";
	}
	
	@PostMapping("/employees/{employeeID}")
	public String updateEmp(@PathVariable Long employeeID, @ModelAttribute("employee") Employee employee, Model model) {
		//call old
		Employee oldEmployee = empService.getEmployeeID(employeeID);
		oldEmployee.setEmployeeID(employeeID);
		oldEmployee.setName(employee.getName());
		oldEmployee.setSalary(employee.getSalary());
		//save new
		empService.updateEmployee(oldEmployee);
		return "redirect:/employees";
	}
	
	@GetMapping("employees/{employeeID}")
	public String deleteEmp(@PathVariable Long employeeID) {
		empService.removeEmpById(employeeID);
		return "redirect:/employees";
	}
}
