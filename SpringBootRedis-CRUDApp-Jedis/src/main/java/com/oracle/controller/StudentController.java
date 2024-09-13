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

import com.oracle.entity.Student;
import com.oracle.repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@PostMapping
	public Student saveStudent(@RequestBody Student student) {
		student.setId(UUID.randomUUID().toString());
		return studentRepository.save(student);
	}

	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable String id) {
		return studentRepository.findById(id).get();
	}

	@GetMapping
	public List<Student> getAllStudents() {
		return (List<Student>) studentRepository.findAll();
	}

	@DeleteMapping("/{id}")
	public void deleteStudentById(@PathVariable String id) {
		studentRepository.deleteById(id);
	}

}
