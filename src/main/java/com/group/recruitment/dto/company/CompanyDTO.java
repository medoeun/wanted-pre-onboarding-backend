package com.group.recruitment.dto.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CompanyDTO {
    private Long companyId; // 회사 ID
    private String companyName;
}
