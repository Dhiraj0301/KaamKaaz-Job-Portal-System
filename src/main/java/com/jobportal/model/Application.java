package com.jobportal.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Application {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User applicant;

    @ManyToOne
    private Job job;

    private String resumeLink;

    public Application(User applicant, Job job, String resumeLink) {
        this.applicant = applicant;
        this.job = job;
        this.resumeLink = resumeLink;
    }
}
