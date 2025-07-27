package com.jobportal.service;

import com.jobportal.model.Application;
import com.jobportal.model.Job;
import com.jobportal.model.User;
import com.jobportal.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired private ApplicationRepository appRepo;

    public void applyForJob(User applicant, Job job, String resumeLink) {
        Application application = new Application(applicant, job, resumeLink);
        appRepo.save(application);
    }

    public List<Application> getApplicationsByEmployer(User employer) {
        return appRepo.findByJob_Employer(employer);
    }
}
