package com.springcloudapi.service;

import java.util.List;

import com.springcloudapi.controller.ProjectDTO;
import com.springcloudapi.dto.StudentDTO;
import com.springcloudapi.entity.StudentDetail;

public interface StudentService {
	public List<StudentDTO> findAll();

	public StudentDetail saveStudent(StudentDTO studentDto);

	public StudentDTO getStudentById(Integer id);

	public StudentDTO updateStudent(Integer id, StudentDTO studentDto);

	public void deleteStudent(Integer id);

	public List<StudentDTO> findStudentByStudentName(String name);

	public StudentDetail assignProjectToStudent(Integer studentId, ProjectDTO projectDTO);

}
