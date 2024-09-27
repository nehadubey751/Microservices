package com.springcloudapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springcloudapi.entity.SubjectDetail;

public interface SubjectRepository extends JpaRepository<SubjectDetail, Integer> {

}
