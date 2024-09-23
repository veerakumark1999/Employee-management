package com.jspider.EmployeeManagement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspider.EmployeeManagement.Dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
	
	public Optional<Employee> findByDepartmentName(String departmentName);
}
