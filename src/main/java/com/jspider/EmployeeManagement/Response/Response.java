package com.jspider.EmployeeManagement.Response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Response <T>{
	private T data;
	private LocalDateTime dateTime;
	private String message;
	private int statusCode;
		
}
