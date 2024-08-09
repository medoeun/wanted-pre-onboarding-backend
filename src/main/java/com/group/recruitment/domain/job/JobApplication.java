package com.group.recruitment.domain.job;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jobapplication")
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Long applicationId;

    @Column(name = "posting_id")
    private Long postingId;

    @Column(name = "user_id")
    private Long userId;

    public JobApplication(Long postingId, Long userId) {
        this.postingId = postingId;
        this.userId = userId;
    }
}
