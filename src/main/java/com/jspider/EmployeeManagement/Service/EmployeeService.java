package com.jspider.EmployeeManagement.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.EmployeeManagement.Dao.EmployeeDao;

import com.jspider.EmployeeManagement.Dto.Employee;

import com.jspider.EmployeeManagement.Response.Response;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao emplDao;

	public Response<Employee> insertEmployee(Employee employee) {
		employee.setLeaveDays(employee.getWorkingDays() - employee.getPresentDays());

		double month_sal = employee.getSalary() * employee.getWorkingDays();

		double employeeCon = 12 / 100 * month_sal;
		double employeerCon = 3.67 / 100 * month_sal;

		double pf = employeeCon + employeerCon;

		employee.setPf(pf);

		double annual_salary = month_sal * 12;
		double tds = 0;
		tds = extracted(annual_salary, tds);
		employee.setTds(tds);
		Employee insertEmployee = emplDao.insertEmployee(employee);
		Response<Employee> resp = new Response<>();
		resp.setData(insertEmployee);
		resp.setDateTime(LocalDateTime.now());
		resp.setMessage("Employee Inserted");
		resp.setStatusCode(201);
		return resp;
	}

	private double extracted(double annual_salary, double tds) {
		if (annual_salary > 250000 && annual_salary < 500000) {
			tds = (annual_salary * 5 / 100) / 12;
			System.out.println(tds);
		} else if (annual_salary > 500000 && annual_salary < 750000) {
			tds = (annual_salary * 10 / 100) / 12;
			System.out.println(tds);
		} else if (annual_salary > 750000 && annual_salary < 1000000) {
			tds = (annual_salary * 15 / 100) / 12;
			System.out.println(tds);
		} else if (annual_salary > 1000000) {
			tds = (annual_salary * 30 / 100) / 12;
			System.out.println(tds);
		}
		return tds;
	}

	public Response<Employee> updateEmployee(Employee employee) {
		employee.setLeaveDays(employee.getWorkingDays() - employee.getPresentDays());

		double month_sal = employee.getSalary() * employee.getWorkingDays();

		double employeeCon = 12 / 100 * month_sal;
		double employeerCon = 3.67 / 100 * month_sal;

		double pf = employeeCon + employeerCon;

		employee.setPf(pf);

		double annual_salary = month_sal * 12;
		double tds = 0;
		tds = extracted(annual_salary, tds);
		employee.setTds(tds);
		Employee updateEmployee = emplDao.updateEmployee(employee);

		Response<Employee> resp = new Response<>();
		resp.setData(updateEmployee);
		resp.setDateTime(LocalDateTime.now());
		resp.setMessage("Updates Successfully");
		resp.setStatusCode(202);
		return resp;

	}

	public Response<List<Employee>> findAllEmp() {
		List<Employee> employees = emplDao.findAllEmp();
		Response<List<Employee>> resp = new Response<>();
		resp.setData(employees);

		resp.setDateTime(LocalDateTime.now());
		resp.setMessage("Employees details getting Successfully!");
		resp.setStatusCode(302);
		return resp;

	}

	public Response<String> deleteEmployee(int employeeId) {
		String deleteId = emplDao.deleteEmployee(employeeId);
		Response<String> response = new Response<>();
		response.setData(deleteId);
		response.setDateTime(LocalDateTime.now());
		response.setMessage("Employee data deleted sucessfull!");
		response.setStatusCode(200);
		return response;
	}

}
