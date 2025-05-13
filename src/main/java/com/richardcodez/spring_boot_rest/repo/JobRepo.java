package com.richardcodez.spring_boot_rest.repo;

import com.richardcodez.spring_boot_rest.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {
    // mocking an actual database

    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Java Developer", "experience", 2, List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
            new JobPost(2, "C# Developer", "experience needed", 1, List.of("C#", "JavaScript")),
            new JobPost(3, "Angular Developer", "2 years experience needed", 2, List.of("typescript", "JavaScript", "HTML", "CSS")),
            new JobPost(4, "Mobile Developer", "3 years experience needed", 3, List.of("kotlin", "JavaScript", "typescript"))
    ));

    public List<JobPost> getAllJobs(){
        return jobs; // Returning the list of job posts
    }

    public void addJob(JobPost job){
        jobs.add(job);
        System.out.println(jobs);
    }

    public JobPost getJob(int postId) {

        for (JobPost job : jobs) {
            if (job.getPostId() == postId)
                return job;
        }
        return null;
    }

    public void updateJob(JobPost jobPost) {
        for(JobPost job : jobs) {
            if(job.getPostId() == jobPost.getPostId()){
                job.setPostDesc(jobPost.getPostDesc());
                job.setPostProfile(jobPost.getPostProfile());
                job.setReqExperience(jobPost.getReqExperience());
                job.setPostTechStack(jobPost.getPostTechStack());
            }
        }
    }

    public void deleteJob(int postId) {
        for(JobPost job : jobs){
            if(job.getPostId() == postId){
                jobs.remove(job);
            }
        }
    }
}