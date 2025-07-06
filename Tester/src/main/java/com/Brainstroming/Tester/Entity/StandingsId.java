package com.Brainstroming.Tester.Entity;

import java.io.Serializable;
import java.util.Objects;

public class StandingsId implements Serializable {
    private String userId;
    private Integer contestId;

    public StandingsId() {
    }

    public StandingsId(String userId, Integer contestId) {
        this.userId = userId;
        this.contestId = contestId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getContestId() {
        return contestId;
    }

    public void setContestId(Integer contestId) {
        this.contestId = contestId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StandingsId that = (StandingsId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(contestId, that.contestId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, contestId);
    }
}
