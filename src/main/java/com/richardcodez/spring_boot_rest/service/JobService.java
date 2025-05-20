package com.richardcodez.spring_boot_rest.service;

import com.richardcodez.spring_boot_rest.model.JobPost;
import com.richardcodez.spring_boot_rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost){
        // jobPost is a DTO because it is getting transferred from one object to another
        repo.save(jobPost);
    }

    public List<JobPost> getAllJobs(){
//        int num = 10/0;     // intended error to see @AfterThrowing an error loggingAspect
        return repo.findAll();
    }

    public JobPost getJob(int postId) {
        return repo.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }

    public void load() {
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
                new JobPost(1, "Java Developer", "experience", 2, List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
                new JobPost(2, "C# Developer", "experience needed", 1, List.of("C#", "JavaScript")),
                new JobPost(3, "Angular Developer", "2 years experience needed", 2, List.of("typescript", "JavaScript", "HTML", "CSS")),
                new JobPost(4, "Mobile Developer", "3 years experience needed", 3, List.of("kotlin", "JavaScript", "typescript"))
        ));

        repo.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}
