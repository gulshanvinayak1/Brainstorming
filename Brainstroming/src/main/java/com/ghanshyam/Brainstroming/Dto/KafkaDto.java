//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ghanshyam.Brainstroming.Dto;

import org.springframework.stereotype.Component;

@Component
public class KafkaDto {
    private Long submissionId;
    private String userId;
    private Long testid;
    private Short score;
    private Integer contestId;
    private String code;
    private Integer problemnum;

    public KafkaDto() {
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

    public Long getTestid() {
        return this.testid;
    }

    public void setTestid(Long testid) {
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
