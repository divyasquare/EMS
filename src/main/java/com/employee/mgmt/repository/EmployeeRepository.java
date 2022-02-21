package com.employee.mgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.mgmt.model.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

}
