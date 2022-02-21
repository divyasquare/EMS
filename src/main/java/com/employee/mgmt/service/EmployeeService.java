package com.employee.mgmt.service;

import java.util.List;

import com.employee.mgmt.model.Employee;

public interface EmployeeService {
 
	List<Employee> getAllEmployee();
	void saveEmployee(Employee employee);
	Employee getEmployeeByID(long id);
	void deleteEmployee(long id);
}
