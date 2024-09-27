package com.springcloudapi.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloudapi.dto.SubjectDTO;
import com.springcloudapi.entity.SubjectDetail;
import com.springcloudapi.exception.ResourceNotFoundException;
import com.springcloudapi.repo.SubjectRepository;
import com.springcloudapi.service.SubjectService;
import com.springcloudapi.util.MessageConstants;


@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	SubjectRepository subjectRepository;

	ModelMapper modelMapper = new ModelMapper();

	public List<SubjectDTO> findAll() {

		List<SubjectDetail> subjectList = subjectRepository.findAll();

		List<SubjectDTO> subjectDTOList = new ArrayList<SubjectDTO>();
		for (SubjectDetail subject : subjectList) {
			SubjectDTO subjectDTO = modelMapper.map(subject, SubjectDTO.class);
			subjectDTOList.add(subjectDTO);
		}
		return subjectDTOList;
	}

	public SubjectDetail saveSubject(SubjectDTO subjectDTO) {

		SubjectDetail subject = modelMapper.map(subjectDTO, SubjectDetail.class);
		return subjectRepository.save(subject);
	}

	public SubjectDTO getSubjectById(Integer id) {

		Optional<SubjectDetail> subjectOptinal = subjectRepository.findById(id);
		SubjectDetail subject = subjectOptinal.get();

		SubjectDTO subjectDTO = modelMapper.map(subject, SubjectDTO.class);
		return subjectDTO;
	}

	public SubjectDTO updateSubject(Integer id, SubjectDTO subjectDto) {

		SubjectDetail subjectDetail = subjectRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(MessageConstants.STANDARD_NOT_FOUND + id));

		subjectDetail.setName(subjectDto.getName());

		SubjectDetail updatedSubjectDetail = subjectRepository.save(subjectDetail);
		return modelMapper.map(updatedSubjectDetail, SubjectDTO.class);

	}

	public void deleteSubject(Integer id) {

		SubjectDetail subjectDetail = subjectRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(MessageConstants.SUBJECT_NOT_FOUND + id));

		subjectRepository.delete(subjectDetail);
	}
}