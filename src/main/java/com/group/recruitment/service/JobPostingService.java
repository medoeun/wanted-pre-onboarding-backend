package com.group.recruitment.service;


import com.group.recruitment.domain.company.Company;
import com.group.recruitment.domain.job.JobPosting;
import com.group.recruitment.dto.company.CompanyRepository;
import com.group.recruitment.dto.job.JobPostingDTO;
import com.group.recruitment.dto.job.JobPostingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobPostingService {

    @Autowired
    private final JobPostingRepository jobPostingRepository;

    @Autowired
    private final CompanyRepository companyRepository;

    // 아래 있는 함수가 시작될 때 start transaction;을 해준다 (트랜잭션을 시작!)
    // 함수가 예외 없이 잘 끝났다면 commit
    // 혹시라도 문제가 있다면 rollback
    @Transactional
    public void createJobPosting(JobPostingDTO jobPostingDTO) {
//        Company company = companyRepository.findById(jobPostingDTO.getCompanyId())
//                .orElseThrow(() -> new IllegalArgumentException("Invalid company ID: " + jobPostingDTO.getCompanyId()));

        jobPostingRepository.save(new JobPosting(jobPostingDTO.getCompanyId(), jobPostingDTO.getPosition(), jobPostingDTO.getDescription(), jobPostingDTO.getCountry(), jobPostingDTO.getDistrict(), jobPostingDTO.getReward(), jobPostingDTO.getSkills()));

    }

}
