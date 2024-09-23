package com.jspider.EmployeeManagement.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.jspider.EmployeeManagement.Dao.DepartmentDao;

import com.jspider.EmployeeManagement.Dto.Department;

import com.jspider.EmployeeManagement.Response.Response;

@Service
public class DepartmentService 
{
	@Autowired
	private DepartmentDao dao;
	
	public Response<Department> insert(Department salary) 
	{
		System.out.println(salary.getDepartmentName());
		Department insertsalary = dao.insertDepartment(salary);
		Response<Department> resp = new Response<>();
		resp.setData(insertsalary);
		resp.setDateTime(LocalDateTime.now());
		resp.setMessage("Data Inserted");
		resp.setStatusCode(201);
		return resp;
		
		
}

	public Response<List<Department>> findAllDepatment() {
		List<Department> salaryDetails=dao.departmentService();
		Response<List<Department>> response=new Response<>();
		response.setData(salaryDetails);
		response.setDateTime(LocalDateTime.now());
		response.setStatusCode(302);
		response.setMessage("Department details found!");
		return response;
		
	}

}
