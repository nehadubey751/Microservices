package com.springcloudapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springcloudapi.entity.StudentDetail;

public interface StudentRepository extends JpaRepository<StudentDetail, Integer> {

	List<StudentDetail> findByName(String name);
	
	
	@Query("SELECT s FROM StudentDetail s WHERE s.name = :studentName")
	
	List<StudentDetail> findStudentWithName(String studentName);

}