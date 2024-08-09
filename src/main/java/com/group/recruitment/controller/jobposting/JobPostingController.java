package com.group.recruitment.controller.jobposting;

import com.group.recruitment.dto.job.CreateJobPostingDTO;
import com.group.recruitment.dto.job.JobApplicationDTO;
import com.group.recruitment.dto.job.JobPostingDTO;
import com.group.recruitment.dto.job.JobPostingDetailDTO;
import com.group.recruitment.service.JobApplicationService;
import com.group.recruitment.service.JobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.HttpStatus;

@RestController
public class JobPostingController {

    @Autowired
    private JobPostingService jobPostingService;

    @Autowired
    private JobApplicationService jobApplicationService;

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

    // 채용공고 상세페이지 조회
    @GetMapping("/jobs/{postingId}")
    public JobPostingDetailDTO readJobPostingDetail(@PathVariable("postingId") Long postingId) {
        return jobPostingService.readJobPostingDetail(postingId);
    }

    // 사용자가 상세페이지에서 채용 공고에 지원
    @PostMapping("/jobs/{postingId}/apply")
    public ResponseEntity<String> applyForJob(@PathVariable("postingId") Long postingId, @RequestBody JobApplicationDTO jobApplicationDTO) {
        try {
            jobApplicationService.applyForJob(postingId, jobApplicationDTO.getUserId());
            return ResponseEntity.status(HttpStatus.CREATED).body("지원이 완료되었습니다.");  //201 Created
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());  //400 Bad Request
        }
    }

}
