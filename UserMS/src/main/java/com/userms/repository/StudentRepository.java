package com.userms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userms.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
