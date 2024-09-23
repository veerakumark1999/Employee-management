package com.jspider.EmployeeManagement.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Department {
	@Id
	private int departmentId;
	@Column(unique = true)
	private String departmentName;

}
