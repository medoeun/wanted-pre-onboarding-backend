package com.group.recruitment.controller.company;

import com.group.recruitment.dto.job.JobPostingDTO;
import com.group.recruitment.service.JobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyController {

    @Autowired
    private JobPostingService jobPostingService;

    // 조회


    // 채용공고 등록
    @PostMapping("/jobs")
    public void createJobPosting(@RequestBody JobPostingDTO jobPostingDTO) {
        jobPostingService.createJobPosting(jobPostingDTO);
    }

    // 채용공고 수정
    @PutMapping("/jobs/{id}")
    public void updateJobPosting(@PathVariable Long id, @RequestBody JobPostingDTO jobPostingDTO) {
        jobPostingService.updateJobPosting(id, jobPostingDTO);
    }


    // 채용공고 삭제
    @DeleteMapping("/jobs")
    public void deleteJobPosting(@RequestParam Long id) {
        jobPostingService.deleteJobPosting(id);
    }

}
