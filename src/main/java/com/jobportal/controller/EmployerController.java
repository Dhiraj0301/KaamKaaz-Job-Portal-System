package com.jobportal.controller;

import com.jobportal.model.Job;
import com.jobportal.model.User;
import com.jobportal.repository.JobRepository;
import com.jobportal.repository.UserRepository;
import com.jobportal.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employer")
public class EmployerController {

    @Autowired private JobRepository jobRepo;
    @Autowired private UserRepository userRepo;
    @Autowired private ApplicationRepository appRepo;

    @GetMapping("/dashboard")
    public String dashboard() {
        return "employer/dashboard";
    }

    @GetMapping("/post-job")
    public String postJobForm(Model model) {
        model.addAttribute("job", new Job());
        return "employer/post-job";
    }

    @PostMapping("/post-job")
    public String postJob(@ModelAttribute Job job, Authentication auth) {
        User employer = userRepo.findByUsername(auth.getName());
        job.setEmployer(employer);
        jobRepo.save(job);
        return "redirect:/employer/dashboard";
    }

    @GetMapping("/applications")
    public String viewApplications(Model model, Authentication auth) {
        User employer = userRepo.findByUsername(auth.getName());
        model.addAttribute("applications", appRepo.findByJob_Employer(employer));
        return "employer/applications";
    }
}
