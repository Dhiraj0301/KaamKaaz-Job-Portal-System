package com.jobportal.service;

import com.jobportal.model.Job;
import com.jobportal.model.User;
import com.jobportal.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired private JobRepository jobRepo;

    public void postJob(Job job) {
        jobRepo.save(job);
    }

    public List<Job> getAllJobs() {
        return jobRepo.findAll();
    }

    public Job getJobById(Long id) {
        return jobRepo.findById(id).orElse(null);
    }
}
