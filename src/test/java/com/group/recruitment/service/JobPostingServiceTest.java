package com.group.recruitment.service;

import com.group.recruitment.domain.job.JobPosting;
import com.group.recruitment.dto.company.CompanyRepository;
import com.group.recruitment.dto.job.JobPostingDTO;
import com.group.recruitment.dto.job.JobPostingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
@ExtendWith(MockitoExtension.class)
class JobPostingServiceTest {

    @Mock
    private JobPostingRepository jobPostingRepository;

    @InjectMocks
    private JobPostingService jobPostingService;

    @Test
    void createJobPosting() {
        //given
        JobPostingDTO jobPostingDTO = new JobPostingDTO(
                1L,
                "Software Engineer",
                "Develop software applications.",
                "USA",
                "CA",
                5000,
                "Java, Spring"
        );

        // save 메서드를 모킹
        when(jobPostingRepository.save(any(JobPosting.class))).thenReturn(new JobPosting());

        // 실행
        jobPostingService.createJobPosting(jobPostingDTO);

        // save가 JobPosting과 함께 한 번 호출되었는지
        verify(jobPostingRepository).save(any(JobPosting.class));
    }
}