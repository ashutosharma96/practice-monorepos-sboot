package com.ashu.springSecDemo.dao;

import com.ashu.springSecDemo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,String>{


    Users findByUsername(String username);

}