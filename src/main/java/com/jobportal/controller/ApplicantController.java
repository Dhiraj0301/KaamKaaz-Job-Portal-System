package com.jobportal.controller;

import com.jobportal.model.Application;
import com.jobportal.model.Job;
import com.jobportal.model.User;
import com.jobportal.repository.ApplicationRepository;
import com.jobportal.repository.JobRepository;
import com.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/applicant")
public class ApplicantController {

    @Autowired private JobRepository jobRepo;
    @Autowired private UserRepository userRepo;
    @Autowired private ApplicationRepository appRepo;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("jobs", jobRepo.findAll());
        return "applicant/dashboard";
    }

    @GetMapping("/job/{id}")
    public String jobDetails(@PathVariable Long id, Model model) {
        model.addAttribute("job", jobRepo.findById(id).orElseThrow());
        return "applicant/job-details";
    }

    @PostMapping("/apply/{jobId}")
    public String apply(@PathVariable Long jobId,
                        @RequestParam String resumeLink,
                        Authentication auth) {
        User applicant = userRepo.findByUsername(auth.getName());
        Job job = jobRepo.findById(jobId).orElseThrow();
        Application app = new Application(applicant, job, resumeLink);
        appRepo.save(app);
        return "redirect:/applicant/dashboard";
    }
}
