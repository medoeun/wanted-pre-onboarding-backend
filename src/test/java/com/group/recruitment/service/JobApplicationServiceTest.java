package com.group.recruitment.service;

import com.group.recruitment.domain.job.JobApplication;
import com.group.recruitment.dto.job.JobApplicationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JobApplicationServiceTest {

    @Mock
    private JobApplicationRepository jobApplicationRepository;

    @InjectMocks
    private JobApplicationService jobApplicationService;

    // 공고 지원 성공
    @Test
    void 채용공고_지원() {
        Long postingId = 1L;
        Long userId = 1L;

        when(jobApplicationRepository.existsByPostingAndUser(postingId, userId)).thenReturn(false);

        jobApplicationService.applyForJob(postingId, userId);

        verify(jobApplicationRepository).save(any(JobApplication.class));

    }

    // 이미 지원한 공고
    @Test
    void 이미_지원한_공고() {
        Long postingId = 1L;
        Long userId = 1L;

        when(jobApplicationRepository.existsByPostingAndUser(postingId, userId)).thenReturn(true);

        try {
            jobApplicationService.applyForJob(postingId, userId);
        } catch (IllegalArgumentException e) {
            assert(e.getMessage().equals("이 공고에 이미 지원한 사용자입니다."));
        }

        verify(jobApplicationRepository, never()).save(any(JobApplication.class));
    }

}