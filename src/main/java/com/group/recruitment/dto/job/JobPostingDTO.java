package com.group.recruitment.dto.job;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class JobPostingDTO {
    private Long postingId; // 공고 ID
    private Long companyId; // 회사 ID
    private String position; // 직위
    private String description; // 설명
    private String country;
    private String district;
    private int reward; // 보상
    private String skills; // 필요 기술

    public JobPostingDTO(Long companyId, String position, String description, String country, String district, int reward, String skills) {
        this.companyId = companyId;
        this.position = position;
        this.description = description;
        this.country = country;
        this.district = district;
        this.reward = reward;
        this.skills = skills;
    }
}
