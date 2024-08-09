package com.group.recruitment.repository.job;

import com.group.recruitment.domain.job.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

    // 사용자가 이미 공고에 지원했는지 확인, 존재하면 true 아니면 false
    @Query("SELECT COUNT(ja) > 0 FROM JobApplication ja WHERE ja.postingId = :postingId AND ja.userId = :userId")
    boolean existsByPostingAndUser(@Param("postingId") Long postingId, @Param("userId") Long userId);

}
