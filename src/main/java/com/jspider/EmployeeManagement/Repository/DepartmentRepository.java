package com.jspider.EmployeeManagement.Repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspider.EmployeeManagement.Dto.Department;


public interface DepartmentRepository extends JpaRepository<Department, Integer>
{

	public Optional<Department> findByDepartmentName(String departmentName);
    
}
