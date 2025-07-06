//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ghanshyam.Brainstroming.Dto;

import java.time.LocalDateTime;

public class SubmissionDto {
    private String userId;
    private Integer contestId;
    private Integer problemnum;
    private String language;
    private LocalDateTime submissionTime;
    private String status;
    private String Code;
    private Short score;
    private Long testid;

    public SubmissionDto() {
    }

    public String toString() {
        String var10000 = this.userId;
        return "SubmissionDto{userId='" + var10000 + "', contestId=" + this.contestId + ", problemnum=" + this.problemnum + ", language='" + this.language + "', submissionTime=" + String.valueOf(this.submissionTime) + ", status='" + this.status + "', Code='" + this.Code + "', score=" + this.score + ", testid=" + this.testid + "}";
    }

    public Integer getContestId() {
        return this.contestId;
    }

    public void setContestId(Integer contestId) {
        this.contestId = contestId;
    }

    public Integer getProblemnum() {
        return this.problemnum;
    }

    public void setProblemnum(Integer problemnum) {
        this.problemnum = problemnum;
    }

    public Long getTestid() {
        return this.testid;
    }

    public void setTestid(Long testid) {
        this.testid = testid;
    }

    public Short getScore() {
        return this.score;
    }

    public void setScore(Short score) {
        this.score = score;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getCode() {
        return this.Code;
    }

    public void setCode(String code) {
        this.Code = code;
    }
}
