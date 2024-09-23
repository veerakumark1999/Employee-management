package com.jspider.EmployeeManagement.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.EmployeeManagement.Dto.Employee;
import com.jspider.EmployeeManagement.Response.Response;
import com.jspider.EmployeeManagement.Service.EmployeeService;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	@PostMapping("/add")
	public ResponseEntity<?> insertEmployee(@RequestBody Employee employee) {
		Response<Employee> res=employeeService.insertEmployee(employee);
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}
	@PutMapping("/update")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee)
	{
		Response<Employee> updateEmployee= employeeService.updateEmployee(employee);
		return new ResponseEntity<>(updateEmployee,HttpStatus.ACCEPTED);
	}
	@GetMapping("/findall")
	public ResponseEntity<?>findAllEmployee() {
		Response<List<Employee>> response=employeeService.findAllEmp();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<?>deleteEmployee(@RequestParam int employeeId){
		Response<String> response=employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	
}
