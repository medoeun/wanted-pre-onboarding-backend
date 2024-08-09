package com.group.recruitment.dto.job;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class JobPostingDetailDTO {
    private Long postingId;
    private String companyName;
    private String country;
    private String district;
    private String position;
    private int reward;
    private String skills;
    private String description;
    private List<Long> otherJobPostingIds;

}

