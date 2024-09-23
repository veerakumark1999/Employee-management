package com.jspider.EmployeeManagement.Dto;



import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int employeeId;
	@Size(min = 2,max=15)
	private String name;
	@NotBlank
	private String emailId;
	@Size(min=3,max=20)
	private String address;
	@Size(min=2,max=10)
	private String departmentName;
	private double workingDays;
	
	private double presentDays;
	private double leaveDays;
	
	private double salary;

	private double pf;
	private double tds;
	
	@ManyToOne
	private Department department;

	}
