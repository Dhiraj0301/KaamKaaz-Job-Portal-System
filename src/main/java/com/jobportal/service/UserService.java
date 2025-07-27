package com.jobportal.service;

import com.jobportal.model.User;
import com.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired private UserRepository userRepo;

    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public boolean existsByUsername(String username) {
        return userRepo.existsByUsername(username);
    }

    public void save(User user) {
        userRepo.save(user);
    }
}
