package com.group.recruitment.domain.job;

import com.group.recruitment.domain.company.Company;
import jakarta.persistence.*;

@Entity
public class JobPosting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    private String position;
    private String description;
    private int reward;
    private String skills;
    private boolean active;





}
