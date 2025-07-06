//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ghanshyam.Brainstroming.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
@Entity
@Table(
        name = "standings",
        indexes = {@Index(
                name = "idx_userId",
                columnList = "user_id"
        ), @Index(
                name = "idx_contestId_rank",
                columnList = "contest_id, rank"
        )}
)
@IdClass(StandingsId.class)
public class Standings {
    @Id
    @Column(
            name = "user_id",
            nullable = false
    )
    private String userId;
    @Id
    @Column(
            name = "contest_id",
            nullable = false
    )
    private Integer contestId;
    @Column(
            name = "ranking"
    )
    private Integer rank;
    @Column(
            name = "s1"
    )
    private Short s1;
    @Column(
            name = "s2"
    )
    private Short s2;
    @Column(
            name = "s3"
    )
    private Short s3;
    @Column(
            name = "s4"
    )
    private Short s4;
    @Column(
            name = "rating_changes"
    )
    private Short ratingChanges;

    public Standings() {
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getContestId() {
        return this.contestId;
    }

    public void setContestId(Integer contestId) {
        this.contestId = contestId;
    }

    public Integer getRank() {
        return this.rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Short getS2() {
        return this.s2;
    }

    public void setS2(Short s2) {
        this.s2 = s2;
    }

    public Short getS3() {
        return this.s3;
    }

    public void setS3(Short s3) {
        this.s3 = s3;
    }

    public Short getS4() {
        return this.s4;
    }

    public void setS4(Short s4) {
        this.s4 = s4;
    }

    public Short getRatingChanges() {
        return this.ratingChanges;
    }

    public void setRatingChanges(Short ratingChanges) {
        this.ratingChanges = ratingChanges;
    }

    public Short getS1() {
        return this.s1;
    }

    public void setS1(Short s1) {
        this.s1 = s1;
    }
}