//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ghanshyam.Brainstroming.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "contesthistory",
        indexes = {@Index(
                name = "idx_contestId_desc",
                columnList = "contestId DESC"
        )}
)
public class ContestHistory {
    @Id
    @Column(
            name = "contestId"
    )
    private Integer contestId;
    @Column(
            name = "contestName",
            nullable = false
    )
    private String contestName;
    @Column(
            name = "dateAndTime",
            nullable = false
    )
    private LocalDateTime dateAndTime;

    public ContestHistory() {
    }

    public Integer getContestId() {
        return this.contestId;
    }

    public void setContestId(Integer contestId) {
        this.contestId = contestId;
    }

    public String getContestName() {
        return this.contestName;
    }

    public void setContestName(String contestName) {
        this.contestName = contestName;
    }

    public LocalDateTime getDateAndTime() {
        return this.dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
}
