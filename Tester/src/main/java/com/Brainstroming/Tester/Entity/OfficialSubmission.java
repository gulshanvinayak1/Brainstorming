//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.Brainstroming.Tester.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(
        name = "officialSubmission",
        indexes = {@Index(
                name = "idx_user_submission_time",
                columnList = "userId, submissionTime DESC"
        ), @Index(
                name = "idx_user_problem",
                columnList = "userId, problemId"
        )}
)
public class OfficialSubmission {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long submissionId;
    @Column(
            nullable = false
    )
    private String userId;
    @Column(
            nullable = false
    )
    private String problemId;
    @Column(
            nullable = false,
            length = 50
    )
    private String language;
    @Column(
            nullable = false
    )
    private LocalDateTime submissionTime;
    @Column(
            length = 20
    )
    private String status;

    public OfficialSubmission() {
    }

    public Long getSubmissionId() {
        return this.submissionId;
    }

    public void setSubmissionId(Long submissionId) {
        this.submissionId = submissionId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProblemId() {
        return this.problemId;
    }

    public void setProblemId(String problemId) {
        this.problemId = problemId;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LocalDateTime getSubmissionTime() {
        return this.submissionTime;
    }

    public void setSubmissionTime(LocalDateTime submissionTime) {
        this.submissionTime = submissionTime;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
