package com.vasanthi.SMS.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vasanthi.SMS.Models.Professor;
import com.vasanthi.SMS.Models.Student;
import com.vasanthi.SMS.Repository.ProfessorRepository;
import com.vasanthi.SMS.Repository.StudentRepository;

/*
 * @author Krishna Vasanthi Yakkala
 */
@Controller
public class StudentController {

	ModelAndView mv = new ModelAndView();

	@Autowired
	public StudentRepository studentRepository;

	@Autowired
	public ProfessorRepository profRepository;

	@RequestMapping("studentHome")
	public ModelAndView home() {
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("add")
	public ModelAndView add() {
		mv.setViewName("addNewStudent");
		mv.addObject("professors",profRepository.findAll());
		return mv;
	}

	@RequestMapping("addNewStudent")
	public ModelAndView addNewStudent(Student student, @RequestParam("professorId") int id) {
		student.setProfessor(profRepository.findById(id).orElse(new Professor()));
		studentRepository.save(student);
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("viewModifyDelete")
	public ModelAndView viewStudent() {
		mv.setViewName("viewStudents");
		Iterable<Student> students = studentRepository.findAll();
		mv.addObject("students", students);
		return mv;
	}

	@RequestMapping("editStudent")
	public ModelAndView editStudent(Student student) {
		studentRepository.save(student);
		mv.setViewName("editStudent");
		return mv;
	}

	@RequestMapping("deleteStudent")
	public ModelAndView deleteStudent(Student student) {
		// find by id
//		Optional<Student> found = studentRepository.findById(student.getId());
//		if (found.isPresent()) {
//			studentRepository.delete(student);
//		}
		// return home();

		// based on name
//		List<Student> studentsFound = studentRepository.findByName(student.getName());
//		for(Student s : studentsFound) {
//			studentRepository.delete(s);
//		}
//		return home();

		Student s = studentRepository.findById(student.getId()).orElse(new Student());
		studentRepository.delete(s);
		return home();
	}

	@RequestMapping("search")
	public ModelAndView searchStudentById(int id) {
		Student student = studentRepository.findById(id).orElse(new Student());
		mv.addObject(student);
		mv.setViewName("searchResults");
		return mv;
	}

	@RequestMapping("addProfessor")
	public ModelAndView addProfessor() {
		mv.setViewName("addNewProfessor");
		return mv;
	}

	@RequestMapping("professorAdded")
	public ModelAndView addnewProfessor(Professor professor) {
		profRepository.save(professor);
		mv.setViewName("home");
		return mv;
	}
}
