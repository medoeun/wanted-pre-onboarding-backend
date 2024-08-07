package com.group.recruitment.controller.company;

import com.group.recruitment.dto.job.JobPostingDTO;
import com.group.recruitment.service.JobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @Autowired
    private JobPostingService jobPostingService;

    // 조회


    // 등록, 수정, 삭제
    @PostMapping("/jobs")
    public void createJobPosting(@RequestBody JobPostingDTO jobPostingDTO) {
        jobPostingService.createJobPosting(jobPostingDTO);
    }


}
