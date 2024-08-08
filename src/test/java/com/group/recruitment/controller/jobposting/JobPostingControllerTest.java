package com.group.recruitment.controller.jobposting;


import com.group.recruitment.dto.job.JobPostingDTO;
import com.group.recruitment.service.JobPostingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(JobPostingController.class)
class JobPostingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JobPostingService jobPostingService;

    @BeforeEach
    void setUp() {
        List<JobPostingDTO> jobPostings = Arrays.asList(
                new JobPostingDTO(1L, "원티드랩", "한국", "서울", "백엔드 주니어 개발자", 1500000, "Python"),
                new JobPostingDTO(2L, "네이버", "한국", "판교", "Django 백엔드 개발자", 1000000, "Django")
        );

        when(jobPostingService.readJobPostings()).thenReturn(jobPostings);

        List<JobPostingDTO> searchResults = Arrays.asList(
                new JobPostingDTO(1L, "원티드랩", "한국", "서울", "백엔드 주니어 개발자", 1500000, "Python")
        );

        when(jobPostingService.searchJobPostings("백엔드")).thenReturn(searchResults);
    }

    @Test
    void createJobPosting() {
    }

    @Test
    void updateJobPosting() {
    }

    @Test
    void deleteJobPosting() {
    }

    @Test
    public void testReadJobPostings() throws Exception {
        mockMvc.perform(get("/jobs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].companyName").value("원티드랩"))
                .andExpect(jsonPath("$[1].companyName").value("네이버"));
    }

    @Test
    public void testSearchJobPostings() throws Exception {
        mockMvc.perform(get("/jobs/search")
                        .param("keyword", "백엔드"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].companyName").value("원티드랩"));
    }
}