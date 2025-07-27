package com.jobportal.controller;

import com.jobportal.model.User;
import com.jobportal.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping({"/", "/login"})
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String processRegister(@Valid @ModelAttribute("user") User user,
                                  BindingResult result, Model model) {
        if (result.hasErrors()) return "register";
        if (userRepo.existsByUsername(user.getUsername())) {
            model.addAttribute("usernameError", "Username already taken");
            return "register";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return "redirect:/login?registered";
    }

    // ✅ Redirect based on user role after login
    @GetMapping("/redirect")
    public String redirectAfterLogin(Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login?error";
        }

        for (GrantedAuthority authority : authentication.getAuthorities()) {
            String role = authority.getAuthority();

            if (role.equals("ROLE_EMPLOYER")) {
                return "redirect:/employer/dashboard";
            } else if (role.equals("ROLE_APPLICANT")) {
                return "redirect:/applicant/dashboard";
            }
        }

        return "redirect:/login?error";
    }
}
