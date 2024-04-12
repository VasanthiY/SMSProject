package com.vasanthi.SMS.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vasanthi.SMS.Models.Student;

/*
 * @author Krishna Vasanthi Yakkala
 */
public interface StudentRepository extends CrudRepository<Student, Integer> {

	List<Student> findByName(String name);

}
