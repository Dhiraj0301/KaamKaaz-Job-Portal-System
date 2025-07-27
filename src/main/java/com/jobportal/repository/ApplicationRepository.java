package com.jobportal.repository;

import com.jobportal.model.Application;
import com.jobportal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByJob_Employer(User employer);
}
