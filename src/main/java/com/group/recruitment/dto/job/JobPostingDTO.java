package com.group.recruitment.dto.job;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class JobPostingDTO {

    //조회 DTO
    private Long postingId;
    private Long companyId;
    private String companyName;
    private String position;
    private String description;
    private String country;
    private String district;
    private int reward;
    private String skills;

    public JobPostingDTO(Long postingId, String companyName, String country, String district, String position, int reward, String skills) {
        this.postingId = postingId;
        this.companyName = companyName;
        this.country = country;
        this.district = district;
        this.position = position;
        this.reward = reward;
        this.skills = skills;
    }

}
