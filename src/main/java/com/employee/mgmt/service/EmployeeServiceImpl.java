package com.employee.mgmt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.mgmt.model.Employee;
import com.employee.mgmt.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl  implements EmployeeService{

	@Autowired
	EmployeeRepository   employeeRepository;
	
	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
		
	}

	@Override
	public void saveEmployee(Employee employee) {
      this.employeeRepository.save(employee);
		
	}

	@Override
	public Employee getEmployeeByID(long id) {
		Optional<Employee> findById = this.employeeRepository.findById(id);
		Employee emp= null;
		if(findById.isPresent())
		{
			 emp = findById.get();
		}
		else
		{
			throw new RuntimeException("Employee not present");
		}
		return emp;
	}

	@Override
	public void deleteEmployee(long id) {
		this.employeeRepository.deleteById(id);
	}

}
