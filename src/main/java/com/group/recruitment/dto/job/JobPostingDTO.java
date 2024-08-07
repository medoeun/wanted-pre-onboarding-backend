package com.group.recruitment.dto.job;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class JobPostingDTO {
    private Long companyId; // 회사 ID
    private String position; // 직위
    private String description; // 설명
    private String country;
    private String district;
    private int reward; // 보상
    private String skills; // 필요 기술
}
