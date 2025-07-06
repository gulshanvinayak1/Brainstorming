
package com.Brainstroming.Tester.kafka;

import org.springframework.stereotype.Component;

@Component
public class KafkaDto {
    private Long submissionId;
    private String userId;
    private Integer testid;
    private Short score;
    private Integer contestId;
    private Integer problemnum;
    private String code;

    public KafkaDto() {
    }

    public String toString() {
        return "KafkaDto{submissionId=" + this.submissionId + ", userId='" + this.userId + "', testid=" + this.testid + ", score=" + this.score + ", contestId=" + this.contestId + ", code='" + this.code + "'}";
    }

    public Integer getProblemnum() {
        return this.problemnum;
    }

    public void setProblemnum(Integer problemnum) {
        this.problemnum = problemnum;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Integer getTestid() {
        return this.testid;
    }

    public void setTestid(Integer testid) {
        this.testid = testid;
    }

    public Integer getContestId() {
        return this.contestId;
    }

    public void setContestId(Integer contestId) {
        this.contestId = contestId;
    }

    public Short getScore() {
        return this.score;
    }

    public void setScore(Short score) {
        this.score = score;
    }
}
