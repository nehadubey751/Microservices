package  com.springcloudapi.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.hc.core5.http.HttpStatus;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springcloudapi.controller.ProjectDTO;
import com.springcloudapi.dto.AddressDTO;
import com.springcloudapi.dto.StandardDTO;
import com.springcloudapi.dto.StudentDTO;
import com.springcloudapi.entity.StudentDetail;
import com.springcloudapi.repo.StudentRepository;
import com.springcloudapi.service.StudentService;



@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	private RestTemplate restTemplate;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<StudentDTO> findAll() {
		List<StudentDTO> studentDtoList = null;

		List<StudentDetail> studentList = studentRepository.findAll();

		studentDtoList = new ArrayList<StudentDTO>();
		for (StudentDetail student : studentList) {

			StudentDTO studentDto = modelMapper.map(student, StudentDTO.class);

			StandardDTO standardDTO = restTemplate.getForObject("http://localhost:9191/api/standards/{id}",
					StandardDTO.class, student.getStandardId());
			studentDto.setStandardName(standardDTO.getName());
			studentDtoList.add(studentDto);
			studentDto.setStandardName(standardDTO.getName());
			studentDtoList.add(studentDto);
		}
		return studentDtoList;
	}


	@Override
	public StudentDetail saveStudent(StudentDTO studentDto) {
    AddressDTO addressDTO = new AddressDTO();
		
		addressDTO.setPerAddress(studentDto.getAddressDTO().getPerAddress());
		addressDTO.setCity(studentDto.getAddressDTO().getCity());
		addressDTO.setPinCode(studentDto.getAddressDTO().getPinCode());
		
		ResponseEntity<?> responseEntity = restTemplate
				.postForEntity("http://localhost:9191/api/address/", addressDTO, AddressDTO.class);

		StudentDetail student = modelMapper.map(studentDto, StudentDetail.class);
	
		
		// Optionally, you can use the response if needed
	    if(responseEntity.getStatusCode().value()== (HttpStatus.SC_CREATED)) {
	    	addressDTO = (AddressDTO) responseEntity.getBody();
	    	student.setAddressId(addressDTO.getId());
	    }

	    // Save the student entity in the student-service repository
	    return studentRepository.save(student);
		
	}

	@Override
	public StudentDTO getStudentById(Integer id) {
		StudentDTO studentDto = null;
		Optional<StudentDetail> studentOptinal = studentRepository.findById(id);

		if (studentOptinal.isPresent()) {
			StudentDetail student = studentOptinal.get();
			studentDto = modelMapper.map(student, StudentDTO.class);
		}

		return studentDto;
	}
	
	@Override
	public StudentDTO updateStudent(Integer id, StudentDTO studentDto) {
		StudentDetail studentDetail = studentRepository.findById(id)
				.orElseThrow();

		studentDetail.setName(studentDto.getName());
		studentDetail.setAge(Integer.parseInt(studentDto.getAge()));

		StudentDetail updatedStudentDetail = studentRepository.save(studentDetail);
		return modelMapper.map(updatedStudentDetail, StudentDTO.class);

	}

	@Override
	public void deleteStudent(Integer id) {
		StudentDetail studentDetail = studentRepository.findById(id)
				.orElseThrow();

		studentRepository.delete(studentDetail);
		
	}
	

	@Override
	public List<StudentDTO> findStudentByStudentName(String name) {
		List<StudentDTO> studentDtoList = null;
		name = name.trim();
		List<StudentDetail> studentList = studentRepository.findStudentWithName(name);

		studentDtoList = new ArrayList<StudentDTO>();
		for (StudentDetail student : studentList) {

			StudentDTO studentDto = modelMapper.map(student, StudentDTO.class); // Student DTO

			studentDtoList.add(studentDto);
		}
		return studentDtoList;
	}


	@Override
	public StudentDetail assignProjectToStudent(Integer studentId, ProjectDTO projectDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}