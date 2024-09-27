package com.springcloudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloudapi.dto.SubjectDTO;
import com.springcloudapi.entity.SubjectDetail;
import com.springcloudapi.service.SubjectService;



@RestController
@RequestMapping("/subjects")
public class SubjectController {

	@Autowired
	SubjectService subjectService;

	@GetMapping("/")
	public List<SubjectDTO> getSubjects() {
		return subjectService.findAll();
	}

	// Save operation
	@PostMapping("/")
	public SubjectDetail saveSubject(@RequestBody SubjectDTO subjectDto) {
		return subjectService.saveSubject(subjectDto);
	}

	@GetMapping("/{id}")
	public SubjectDTO getSubjectById(@PathVariable Integer id) {
		return subjectService.getSubjectById(id);
	}

	@PutMapping("/{id}")
	public SubjectDTO updateSubject(@PathVariable Integer id, @RequestBody SubjectDTO subjectDto) {
		return subjectService.updateSubject(id, subjectDto);
	}

	@DeleteMapping("/{id}")
	public void deleteSubject(@PathVariable Integer id) {
		subjectService.deleteSubject(id);
	}
}
