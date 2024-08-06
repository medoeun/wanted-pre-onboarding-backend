package com.group.recruitment.domain.company;

import com.group.recruitment.domain.job.JobApplication;
import com.group.recruitment.domain.job.JobPosting;
import jakarta.persistence.*;

import java.security.PrivateKey;
import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "company")    // jpa, 하나의 회사가 여러개의 jobPosting
    private List<JobPosting> jobPostings;   // 회사에 속한 채용 공고들의 목록

    public Company(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<JobPosting> getJobPostings() {
        return jobPostings;
    }
}
