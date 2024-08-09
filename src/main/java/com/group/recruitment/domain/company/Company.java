package com.group.recruitment.domain.company;

import com.group.recruitment.domain.job.JobApplication;
import com.group.recruitment.domain.job.JobPosting;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Company {

    @Id
    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "company_name")
    private String companyName;

    @OneToMany(mappedBy = "companyId")    // jpa, 하나의 회사가 여러개의 jobPosting
    private List<JobPosting> jobPostings;   // 회사에 속한 채용 공고들의 목록

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public Company(Long companyId, String companyName) {
        this.companyId = companyId;
        this.companyName = companyName;
    }
}
