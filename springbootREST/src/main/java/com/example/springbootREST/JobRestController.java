package com.example.springbootREST;

import com.example.springbootREST.model.JobPost;
import com.example.springbootREST.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId){
        return service.getJob(postId);
    }

    @PostMapping("/jobPost")
    public String addJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
        return "Job added successfully";
    }

    @PutMapping("/jobPost")
    public String updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return "Job Updated Successfully";
    }

    @DeleteMapping("/jobPost/{postId}")
    public String deleteJob(@PathVariable("postId") int id){
        service.deleteJob(id);
        return "Job Deleted successfully";
    }

}
