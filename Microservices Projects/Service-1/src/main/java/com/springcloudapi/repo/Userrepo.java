package com.springcloudapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springcloudapi.entity.User;

@Repository
public interface Userrepo extends JpaRepository<User,Integer> {

}
