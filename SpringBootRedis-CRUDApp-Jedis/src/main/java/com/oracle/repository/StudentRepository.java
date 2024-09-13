package com.oracle.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oracle.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {

}
