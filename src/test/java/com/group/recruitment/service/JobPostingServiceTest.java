package com.group.recruitment.service;

import com.group.recruitment.domain.company.Company;
import com.group.recruitment.domain.job.JobPosting;
import com.group.recruitment.dto.company.CompanyRepository;
import com.group.recruitment.dto.job.CreateJobPostingDTO;
import com.group.recruitment.dto.job.JobPostingDTO;
import com.group.recruitment.dto.job.JobPostingDetailDTO;
import com.group.recruitment.dto.job.JobPostingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class JobPostingServiceTest {

    @Mock
    private JobPostingRepository jobPostingRepository;

    @Mock
    private CompanyRepository companyRepository;

    @InjectMocks
    private JobPostingService jobPostingService;

    @Test
    void 채용공고_등록() {
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

        // companyId가 1L인 Company 객체를 모킹
        Company mockCompany = new Company(1L, "Mock Company");
        when(companyRepository.findById(1L)).thenReturn(Optional.of(mockCompany));

        when(jobPostingRepository.save(any(JobPosting.class))).thenReturn(new JobPosting());

        // Create
        jobPostingService.createJobPosting(createJobPostingDTO);

        // save가 JobPosting과 함께 한 번 호출되었는지
        verify(jobPostingRepository).save(any(JobPosting.class));
    }

    @Test
    void 채용공고_수정() {
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

        // Update
        jobPostingService.updateJobPosting(1L, updatedCreateJobPostingDTO);

        verify(jobPostingRepository).findById(eq(1L));
        verify(jobPostingRepository).save(any(JobPosting.class));
    }

    @Test
    void 채용공고_삭제() {
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

        // Delete
        jobPostingService.deleteJobPosting(1L);

        verify(jobPostingRepository).findById(eq(1L));
        verify(jobPostingRepository).delete(any(JobPosting.class));
    }

    @Test
    void 채용공고_조회() {

        List<JobPostingDTO> jobPostings = Arrays.asList(
                new JobPostingDTO(1L, "원티드랩", "한국", "서울", "백엔드 주니어 개발자", 1500000, "Python"),
                new JobPostingDTO(2L, "네이버", "한국", "판교", "Django 백엔드 개발자", 1000000, "Django")
        );

        when(jobPostingRepository.readJobPostings()).thenReturn(jobPostings);
        List<JobPostingDTO> result = jobPostingService.readJobPostings();

        verify(jobPostingRepository).readJobPostings();

        //ASSERT: 조건이 거짓일 경우 'Assertion Error'
        assert (result.size() == 2); // 리스트 사이즈 확인
        assert (result.get(0).getCompanyName().equals("원티드랩"));  // 리스트 index 0의 회사명 확인
        assert (result.get(1).getCompanyName().equals("네이버"));

    }

    @Test
    void 채용공고_검색() {
        List<JobPostingDTO> jobPostings = Arrays.asList(
                new JobPostingDTO(1L, "원티드랩", "한국", "서울", "백엔드 주니어 개발자", 1500000, "Python")
        );

        when(jobPostingRepository.searchJobPostings(eq("백엔드"))).thenReturn(jobPostings);


        List<JobPostingDTO> result = jobPostingService.searchJobPostings("백엔드");

        verify(jobPostingRepository).searchJobPostings(eq("백엔드"));
        assert (result.size() == 1);
        assert (result.get(0).getCompanyName().equals("원티드랩"));

    }

    // 키워드 검색결과 없을 시
    @Test
    void 채용공고_검색_결과없음() {
        when(jobPostingRepository.searchJobPostings(eq("아무거나"))).thenReturn(Collections.emptyList());

        List<JobPostingDTO> result = jobPostingService.searchJobPostings("아무거나");

        verify(jobPostingRepository).searchJobPostings(eq("아무거나"));
        assert (result.isEmpty());
    }
    
    // 상세페이지 조회
    @Test
    void 채용_상세페이지() {
        Long postingId = 1L;
        JobPosting jobPosting = new JobPosting(postingId, 1L, "백엔드 주니어 개발자", "백엔드 개발자를 채용합니다. 자격요건은..", "한국", "서울", 1000000, "Python");
        Company company = new Company(1L, "원티드랩");
        List<Long> otherJobPostingIds = Arrays.asList(2L, 3L);

        when(jobPostingRepository.findById(postingId)).thenReturn(Optional.of(jobPosting));
        when(companyRepository.findById(jobPosting.getCompanyId())).thenReturn(Optional.of(company));
        when(jobPostingRepository.otherJobPostings(eq(1L), eq(1L))).thenReturn(otherJobPostingIds);

        JobPostingDetailDTO result = jobPostingService.readJobPostingDetail(postingId);

        verify(jobPostingRepository).findById(postingId);
        verify(companyRepository).findById(jobPosting.getCompanyId());
        verify(jobPostingRepository).otherJobPostings(eq(1L), eq(1L));

        assert(result.getPostingId().equals(postingId));
        assert(result.getCompanyName().equals("원티드랩"));
        assert(result.getCountry().equals("한국"));
        assert(result.getDistrict().equals("서울"));
        assert(result.getPosition().equals("백엔드 주니어 개발자"));
        assert(result.getReward() == 1000000);
        assert(result.getSkills().equals("Python"));
        assert(result.getDescription().equals("백엔드 개발자를 채용합니다. 자격요건은.."));
        assert(result.getOtherJobPostingIds().equals(otherJobPostingIds));
    }

}