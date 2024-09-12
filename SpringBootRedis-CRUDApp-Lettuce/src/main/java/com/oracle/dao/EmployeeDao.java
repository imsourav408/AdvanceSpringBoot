package com.oracle.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.oracle.model.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	private static final String KEY = "EMPLOYEE";

	public String addEmployee(Employee employee) {
		redisTemplate.opsForHash().put(KEY, employee.getEmpno(), employee);
		return "Employee added successfully having empno: " + employee.getEmpno();
	}

	public Employee getEmployeeByEmpno(String empno) {
		return (Employee) redisTemplate.opsForHash().get(KEY, empno);
	}

	public List<Employee> getAllEmployees() {
		Map<Object, Object> entries = redisTemplate.opsForHash().entries(KEY);
		Collection<Object> employeeCollection = entries.values();
		List<Employee> employees = employeeCollection.stream().map(values -> (Employee) values)
				.collect(Collectors.toList());
		return employees;
	}

	public void deleteEmployeeByEmpno(String empno) {
		redisTemplate.opsForHash().delete(KEY, empno);
	}

}
