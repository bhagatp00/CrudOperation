package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RequestMapping("/students")
@RestController
public class MyController {

	@Autowired
	private StudentService service;
	
	@PostMapping
	public Student addStudents(@RequestBody Student student)
	{
		return service.addStudent(student);
	}
	
	@GetMapping("/{id}")
	public Student getStudent(@PathVariable Long id)
	{
		return service.getStudent(id);
	}
	
	@GetMapping
	public List<Student> getAllStudent()
	{
		return service.getAllStudent();
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student student)
	{
		return service.updateStudent(id, student);
	}
	
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable Long id)
	{
		service.deleteStudent(id);
		return"Student deleted Successfully";
	}
	
}
