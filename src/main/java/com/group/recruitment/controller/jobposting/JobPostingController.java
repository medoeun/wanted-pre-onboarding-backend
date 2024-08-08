package com.group.recruitment.controller.jobposting;

import com.group.recruitment.dto.job.CreateJobPostingDTO;
import com.group.recruitment.dto.job.JobPostingDTO;
import com.group.recruitment.service.JobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobPostingController {

    @Autowired
    private JobPostingService jobPostingService;

    // 채용공고 등록
    @PostMapping("/jobs")
    public void createJobPosting(@RequestBody CreateJobPostingDTO createJobPostingDTO) {
        jobPostingService.createJobPosting(createJobPostingDTO);
    }

    // 채용공고 수정
    @PutMapping("/jobs/{id}")   // 에러해결: 1) @PathVariable 속성 이름 기재, 2) -parameters 옵션
    public void updateJobPosting(@PathVariable("id") Long id, @RequestBody CreateJobPostingDTO createJobPostingDTO) {
        jobPostingService.updateJobPosting(id, createJobPostingDTO);
    }

    // 채용공고 삭제
    @DeleteMapping("/jobs/{id}")
    public void deleteJobPosting(@PathVariable("id") Long id) {
        jobPostingService.deleteJobPosting(id);
    }

    // 채용공고 목록 조회
    @GetMapping("/jobs")
    public List<JobPostingDTO> readJobPostings() {
        return jobPostingService.readJobPostings();
    }

    // 채용공고 키워드 검색
    @GetMapping("/jobs/search")
    public List<JobPostingDTO> searchJobPostings(@RequestParam("keyword") String keyword) {
        return jobPostingService.searchJobPostings(keyword);
    }
}
