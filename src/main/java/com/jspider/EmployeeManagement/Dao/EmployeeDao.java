package com.jspider.EmployeeManagement.Dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspider.EmployeeManagement.Dto.Department;
import com.jspider.EmployeeManagement.Dto.Employee;
import com.jspider.EmployeeManagement.Repository.DepartmentRepository;
import com.jspider.EmployeeManagement.Repository.EmployeeRepository;




@Repository
public class EmployeeDao {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	
	public Employee insertEmployee(Employee employee) 
	{	   
		Optional<Department> dname=departmentRepository.findByDepartmentName(employee.getDepartmentName());
		if(dname.isPresent()) {
			employee.setDepartment(dname.get());
			Employee save = employeeRepository.save(employee);
			return save;
		}
	    	
		throw new IllegalArgumentException("Data not Inserted!");
	
	}


	public Employee updateEmployee(Employee employee) 
	{
		Optional<Employee> byId = employeeRepository.findById(employee.getEmployeeId());
		if(byId.isPresent())
		{
			Employee save = employeeRepository.save(employee);
			return save;
		}
		throw new IllegalArgumentException("Incorrect EmployeeId");
			
	}


	public List<Employee> findAllEmp() {
		List<Employee> res=employeeRepository.findAll();
		return res;
	}


	public String deleteEmployee(int employeeId) {
		Optional<Employee> employee=employeeRepository.findById(employeeId);
		if(employee.isPresent()) {
			employeeRepository.deleteById(employeeId);
			return "Deletion is sucessfull!";
			
		}
		else {
			return "employee data not found";
		}
	}

}
