package com.oracle.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.dao.EmployeeDao;
import com.oracle.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;

	@PostMapping
	public String saveEmployee(@RequestBody Employee employee) {
		employee.setEmpno(UUID.randomUUID().toString());
		return employeeDao.addEmployee(employee);
	}

	@GetMapping("/{empno}")
	public Employee getEmployeeByEmpno(@PathVariable String empno) {
		return employeeDao.getEmployeeByEmpno(empno);
	}

	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@DeleteMapping("/{empno}")
	public void deleteEmployeeByEmpno(@PathVariable String empno) {
		employeeDao.deleteEmployeeByEmpno(empno);
	}

}
