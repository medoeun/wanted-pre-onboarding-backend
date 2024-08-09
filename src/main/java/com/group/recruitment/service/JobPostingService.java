package com.group.recruitment.service;


import com.group.recruitment.domain.company.Company;
import com.group.recruitment.domain.job.JobPosting;
import com.group.recruitment.repository.company.CompanyRepository;
import com.group.recruitment.dto.job.CreateJobPostingDTO;
import com.group.recruitment.dto.job.JobPostingDTO;
import com.group.recruitment.dto.job.JobPostingDetailDTO;
import com.group.recruitment.repository.job.JobPostingRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostingService {

    @Autowired
    private final JobPostingRepository jobPostingRepository;

    @Autowired
    private final CompanyRepository companyRepository;


    // 채용공고 등록
    @Transactional
    public void createJobPosting(CreateJobPostingDTO createJobPostingDTO) {
        Company company = companyRepository.findById(createJobPostingDTO.getCompanyId())
                .orElseThrow(() -> new IllegalArgumentException("잘못된 companyID: " + createJobPostingDTO.getCompanyId()));

        jobPostingRepository.save(new JobPosting(
                createJobPostingDTO.getCompanyId(),
                createJobPostingDTO.getPosition(),
                createJobPostingDTO.getDescription(),
                createJobPostingDTO.getCountry(),
                createJobPostingDTO.getDistrict(),
                createJobPostingDTO.getReward(),
                createJobPostingDTO.getSkills()
        ));
    }

    // 채용공고 수정 (회사 id 이외)
    @Transactional
    public void updateJobPosting(Long id, CreateJobPostingDTO createJobPostingDTO) {
        JobPosting jobPosting = jobPostingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 postingID: " + id));

        jobPosting.updateJobPosting(
                createJobPostingDTO.getPosition(),
                createJobPostingDTO.getDescription(),
                createJobPostingDTO.getCountry(),
                createJobPostingDTO.getDistrict(),
                createJobPostingDTO.getReward(),
                createJobPostingDTO.getSkills()
        );

        jobPostingRepository.save(jobPosting);
    }

    // 채용공고 삭제
    @Transactional
    public void deleteJobPosting(Long id) {
        JobPosting jobPosting = jobPostingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 postingID: " + id));

        jobPostingRepository.delete(jobPosting);
    }

    // 채용공고 목록 조회
    @Transactional(readOnly = true)
    public List<JobPostingDTO> readJobPostings() {
        return jobPostingRepository.readJobPostings();
    }

    // 채용공고 키워드 검색
    @Transactional(readOnly = true)
    public List<JobPostingDTO> searchJobPostings(String keyword) {
        return jobPostingRepository.searchJobPostings(keyword);
    }

    // 채용공고 상세페이지
    @Transactional
    public JobPostingDetailDTO readJobPostingDetail(Long postingId) {
        JobPosting jobPosting = jobPostingRepository.findById(postingId)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 postingID: " + postingId));

        Company company = companyRepository.findById(jobPosting.getCompanyId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid company ID: " + jobPosting.getCompanyId()));

        List<Long> otherJobPostingIds = jobPostingRepository.otherJobPostings(company.getCompanyId(), postingId);

        return new JobPostingDetailDTO(
                jobPosting.getPostingId(),
                company.getCompanyName(),
                jobPosting.getCountry(),
                jobPosting.getDistrict(),
                jobPosting.getPosition(),
                jobPosting.getReward(),
                jobPosting.getSkills(),
                jobPosting.getDescription(),
                otherJobPostingIds
        );
    }
}
