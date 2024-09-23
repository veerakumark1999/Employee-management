package com.jspider.EmployeeManagement.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.EmployeeManagement.Dto.Department;

import com.jspider.EmployeeManagement.Response.Response;
import com.jspider.EmployeeManagement.Service.DepartmentService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@CrossOrigin
@RestController
@RequestMapping("/department")
class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/insert")
	public ResponseEntity<?> insertSalary(@RequestBody Department salary) {

		Response<Department> res = departmentService.insert(salary);
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}
	@GetMapping("/findall")
	public ResponseEntity<?> findAllSalary() {
		Response<List<Department>> response=departmentService.findAllDepatment();
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	

}

