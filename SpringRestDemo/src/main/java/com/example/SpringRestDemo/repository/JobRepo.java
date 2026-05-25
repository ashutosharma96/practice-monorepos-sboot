package com.example.SpringRestDemo.repository;


import com.example.SpringRestDemo.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer>{


    List<JobPost> findByPostProfileContainingOrPostDescContaining(String keyword, String keyword1);
}
