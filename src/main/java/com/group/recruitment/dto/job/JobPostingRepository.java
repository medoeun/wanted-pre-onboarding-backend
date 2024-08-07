package com.group.recruitment.dto.job;

import com.group.recruitment.domain.company.Company;
import com.group.recruitment.domain.job.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
}
