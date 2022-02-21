package com.employee.mgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.mgmt.model.Employee;
import com.employee.mgmt.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService   employeeService;
	
	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		model.addAttribute("employeeList",employeeService.getAllEmployee());
		return "index";
	}
	@GetMapping("/showEmployeeFrom")
	public String showNewForm(Model model)
	{
		Employee employee= new Employee();
		model.addAttribute("employee",employee);
		return "new_employee";
		
	}
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee emp)
	{
		employeeService.saveEmployee(emp);
		return "redirect:/";
		
	}
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable("id") long id,Model m)
	{
		Employee employee = employeeService.getEmployeeByID(id);
		m.addAttribute("employee",employee);
		
		return "update_employee";
		
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") long id,Model m)
	{
	   employeeService.deleteEmployee(id);
		return "redirect:/";

		
	}
}
