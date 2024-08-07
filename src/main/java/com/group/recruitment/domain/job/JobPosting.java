package com.group.recruitment.domain.job;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name="jobposting")
@NoArgsConstructor
@AllArgsConstructor
public class JobPosting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="posting_id")
    private Long postingId = null;

    @Column(name="company_id")
    private Long companyId;
    private String position;
    private String description;
    private String country;
    private String district;
    private int reward;
    private String skills;

    public JobPosting(Long companyId, String position, String description, String country, String district, int reward, String skills) {
        if (companyId == null || companyId.describeConstable().isEmpty()) {
            throw new IllegalArgumentException(String.format("잘못된 companyId(%s)가 들어왔습니다", companyId));
        }

        this.companyId = companyId;
        this.position = position;
        this.description = description;
        this.country = country;
        this.district = district;
        this.reward = reward;
        this.skills = skills;
    }

    public void updateJobPosting(String position, String description, String country, String district, int reward, String skills) {
        this.position = position;
        this.description = description;
        this.country = country;
        this.district = district;
        this.reward = reward;
        this.skills = skills;
    }

}
