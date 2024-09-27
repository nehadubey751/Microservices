package com.springcloudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springcloudapi.dto.StudentDTO;
import com.springcloudapi.entity.StudentDetail;
import com.springcloudapi.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public ResponseEntity<List<StudentDTO>> getStudents() {
        List<StudentDTO> studentDTOList = studentService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(studentDTOList);
    }

    // Save operation
    @PostMapping("/id")
    public ResponseEntity<StudentDetail> saveStudent(@RequestBody StudentDTO studentDto) {
        StudentDetail student = studentService.saveStudent(studentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getStudentById(@PathVariable Integer id) {
        StudentDTO studentDTO = studentService.getStudentById(id);

        if (studentDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
       return ResponseEntity.status(HttpStatus.OK).body(studentDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Integer id, @RequestBody StudentDTO studentDto) {
        StudentDTO updatedStudent = studentService.updateStudent(id,
        		studentDto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/searchStudent")
    public ResponseEntity<List<StudentDTO>> findStudentByStudentName(@RequestParam String name) {
        List<StudentDTO> studentDTOList = studentService.findStudentByStudentName(name);
        return ResponseEntity.status(HttpStatus.OK).body(studentDTOList);
    }

    @PostMapping("/assignProject/{studentId}")
    public ResponseEntity<StudentDetail> addProjectToStudent(@PathVariable("studentId") Integer studentId, @RequestBody ProjectDTO projectDTO) 
    {
    	StudentDetail student = studentService.assignProjectToStudent(studentId, projectDTO);
		return null;
    }
}
        
        
        
        
        
        
