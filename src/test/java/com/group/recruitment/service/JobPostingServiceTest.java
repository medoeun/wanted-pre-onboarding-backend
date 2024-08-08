package com.group.recruitment.service;

import com.group.recruitment.domain.job.JobPosting;
import com.group.recruitment.dto.job.CreateJobPostingDTO;
import com.group.recruitment.dto.job.JobPostingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import java.util.Optional;
@ExtendWith(MockitoExtension.class)
class JobPostingServiceTest {

    @Mock
    private JobPostingRepository jobPostingRepository;

    @InjectMocks
    private JobPostingService jobPostingService;

    @Test
    void createJobPosting() {
        //given
        CreateJobPostingDTO createJobPostingDTO = new CreateJobPostingDTO(
                1L,
                "Software Engineer",
                "Develop software applications",
                "한국",
                "서울",
                5000,
                "Java, Spring"
        );

        // save 메서드를 모킹
        when(jobPostingRepository.save(any(JobPosting.class))).thenReturn(new JobPosting());

        // 실행
        jobPostingService.createJobPosting(createJobPostingDTO);

        // save가 JobPosting과 함께 한 번 호출되었는지
        verify(jobPostingRepository).save(any(JobPosting.class));
    }

    @Test
    public void testUpdateJobPosting() {
        JobPosting existingJobPosting = new JobPosting(
                1L,
                "Software Engineer",
                "Develop software applications",
                "한국",
                "서울",
                5000,
                "Java, Spring"
        );

        when(jobPostingRepository.findById(eq(1L))).thenReturn(Optional.of(existingJobPosting));

        // 업데이트 할 공고
        CreateJobPostingDTO updatedCreateJobPostingDTO = new CreateJobPostingDTO(
                1L,
                "Senior Software Engineer",
                "Develop and lead software applications",
                "한국",
                "판교",
                10000,
                "Java, Spring, Leadership"
        );

        // 실행
        jobPostingService.updateJobPosting(1L, updatedCreateJobPostingDTO);

        verify(jobPostingRepository).findById(eq(1L));
        verify(jobPostingRepository).save(any(JobPosting.class));
    }

    @Test
    public void testDeleteJobPosting() {
        JobPosting existingJobPosting = new JobPosting(
                1L,
                "Software Engineer",
                "Develop software applications",
                "한국",
                "서울",
                5000,
                "Java, Spring"
        );

        when(jobPostingRepository.findById(eq(1L))).thenReturn(Optional.of(existingJobPosting));

        // 삭제
        jobPostingService.deleteJobPosting(1L);

        verify(jobPostingRepository).findById(eq(1L));
        verify(jobPostingRepository).delete(any(JobPosting.class));
    }


}