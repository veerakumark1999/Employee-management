
package com.jspider.EmployeeManagement.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspider.EmployeeManagement.Dto.Department;
import com.jspider.EmployeeManagement.Dto.Employee;

import com.jspider.EmployeeManagement.Repository.DepartmentRepository;

@Repository
public class DepartmentDao {

	@Autowired
	DepartmentRepository departmentRepository;

	public Department insertDepartment(Department department) {
      Optional<Department> optional=departmentRepository.findById(department.getDepartmentId());
      if(optional.isEmpty()) {
		Department save = departmentRepository.save(department);
		return save;
		
	}
      throw new IllegalArgumentException("Duplicate data is not allowed!");
	}

	public List<Department> departmentService() {
		List<Department> list = departmentRepository.findAll();
		return list;
	}

}
