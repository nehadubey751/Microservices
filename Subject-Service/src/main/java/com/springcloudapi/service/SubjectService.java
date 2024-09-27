package com.springcloudapi.service;

import java.util.List;

import com.springcloudapi.dto.SubjectDTO;
import com.springcloudapi.entity.SubjectDetail;


public interface SubjectService {

	public List<SubjectDTO> findAll();

	public SubjectDetail saveSubject(SubjectDTO subjectDto);

	public SubjectDTO getSubjectById(Integer id);

	public SubjectDTO updateSubject(Integer id, SubjectDTO subjectDto);

	public void deleteSubject(Integer id);
}