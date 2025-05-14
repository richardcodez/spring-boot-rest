package com.richardcodez.spring_boot_rest.repo;

import com.richardcodez.spring_boot_rest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);

}

//public List<JobPost> getAllJobs(){
//    return jobs; // Returning the list of job posts
//}
//
//public void addJob(JobPost job){
//    jobs.add(job);
//    System.out.println(jobs);
//}
//
//public JobPost getJob(int postId) {
//
//    for (JobPost job : jobs) {
//        if (job.getPostId() == postId)
//            return job;
//    }
//    return null;
//}
//
//public void updateJob(JobPost jobPost) {
//    for(JobPost job : jobs) {
//        if(job.getPostId() == jobPost.getPostId()){
//            job.setPostDesc(jobPost.getPostDesc());
//            job.setPostProfile(jobPost.getPostProfile());
//            job.setReqExperience(jobPost.getReqExperience());
//            job.setPostTechStack(jobPost.getPostTechStack());
//        }
//    }
//}
//
//public void deleteJob(int postId) {
//    for(JobPost job : jobs){
//        if(job.getPostId() == postId){
//            jobs.remove(job);
//        }
//    }
//}
