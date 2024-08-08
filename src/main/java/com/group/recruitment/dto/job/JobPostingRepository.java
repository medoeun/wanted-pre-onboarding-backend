package com.group.recruitment.dto.job;

import com.group.recruitment.domain.company.Company;
import com.group.recruitment.domain.job.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {

    // 채용공고 모두 조회
    @Query("SELECT com.group.recruitment.dto.job.JobPostingDTO(j.id, c.name, j.country, j.district, j.position, j.reward, j.skills) " +
            "FROM JobPosting j JOIN Company c ON j.companyId = c.id")
    List<JobPostingDTO> readJobPostings();

    // 키워드 기반 채용공고 검색
    @Query("SELECT com.group.recruitment.dto.job.JobPostingDTO(j.id, c.name, j.country, j.district, j.position, j.reward, j.skills) " +
            "FROM JobPosting j JOIN Company c ON j.companyId = c.id " +
            "WHERE c.name LIKE %:keyword% " +
            "OR j.position LIKE %:keyword% " +
            "OR j.skills LIKE %:keyword%")
    List<JobPostingDTO> searchJobPostings(@Param("keyword") String keyword);
}
