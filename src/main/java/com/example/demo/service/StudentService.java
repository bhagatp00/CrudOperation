package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository ;
	
	
	public Student addStudent(Student student)
	{
		return studentRepository.save(student);
	}
	
	public Student getStudent(Long id)
	{
		return studentRepository.findById(id).orElse(null);
	}
	
	public List<Student> getAllStudent()
	{
		return studentRepository.findAll();
	}
	
	
	public Student updateStudent(Long id ,Student studentDetails)
	{
		Student student = studentRepository.findById(id).orElse(studentDetails);
		
		if(student != null)
		{
			student.setName(studentDetails.getName());
			student.setEmail(studentDetails.getEmail());
			student.setCourse(studentDetails.getCourse());
		   
		   return   studentRepository.save(student);
			
		}
		
		return null;
		
	}
	
	public void deleteStudent(Long id)
	{
		studentRepository.deleteById(id);
	}
}