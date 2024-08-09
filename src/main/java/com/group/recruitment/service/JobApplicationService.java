package com.group.recruitment.service;

import com.group.recruitment.domain.job.JobApplication;
import com.group.recruitment.repository.job.JobApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class JobApplicationService {

    @Autowired
    private final JobApplicationRepository jobApplicationRepository;

    @Transactional
    public void applyForJob(Long postingId, Long userId) {
        // 공고 지원여부 확인
        if (jobApplicationRepository.existsByPostingAndUser(postingId, userId)) {
            throw new IllegalArgumentException("이 공고에 이미 지원한 사용자입니다.");
        }

        // 채용공고 지원
        JobApplication jobApplication = new JobApplication(postingId, userId);
        jobApplicationRepository.save(jobApplication);
    }
}
