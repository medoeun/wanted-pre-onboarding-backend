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


    // 채용공고 등록
    @Transactional
    public void createJobPosting(JobPostingDTO jobPostingDTO) {
//        Company company = companyRepository.findById(jobPostingDTO.getCompanyId())
//                .orElseThrow(() -> new IllegalArgumentException("잘못된 companyID: " + jobPostingDTO.getCompanyId()));

        jobPostingRepository.save(new JobPosting(
                jobPostingDTO.getCompanyId(),
                jobPostingDTO.getPosition(),
                jobPostingDTO.getDescription(),
                jobPostingDTO.getCountry(),
                jobPostingDTO.getDistrict(),
                jobPostingDTO.getReward(),
                jobPostingDTO.getSkills()
        ));
    }

    // 채용공고 수정 (회사 id 이외)
    @Transactional
    public void updateJobPosting(Long id, JobPostingDTO jobPostingDTO) {
        JobPosting jobPosting = jobPostingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 postingID: " + id));

        jobPosting.updateJobPosting(
                jobPostingDTO.getPosition(),
                jobPostingDTO.getDescription(),
                jobPostingDTO.getCountry(),
                jobPostingDTO.getDistrict(),
                jobPostingDTO.getReward(),
                jobPostingDTO.getSkills()
        );

        jobPostingRepository.save(jobPosting);
    }

    // 채용공고 삭제
    public void deleteJobPosting(Long id) {

    }

}
