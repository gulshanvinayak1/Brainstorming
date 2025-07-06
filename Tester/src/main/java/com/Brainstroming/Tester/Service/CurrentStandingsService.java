//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.Brainstroming.Tester.Service;

import com.Brainstroming.Tester.Entity.CurrentStandings;
import com.Brainstroming.Tester.Entity.StandingsId;
import com.Brainstroming.Tester.Repository.CurrentStandingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CurrentStandingsService {
    @Autowired
    private CurrentStandingsRepository currentStandingsRepositoryrepository;

    public CurrentStandingsService() {
    }

    public boolean existing(String userId, Integer contestId) {
        return this.currentStandingsRepositoryrepository.existsById(new StandingsId(userId, contestId));
    }

    public void add(CurrentStandings currentStandings) {
        this.currentStandingsRepositoryrepository.save(currentStandings);
    }

    @Transactional
    public void incrementS1(String userId, Integer contestId, Short increment) {
        this.currentStandingsRepositoryrepository.incrementS1(userId, contestId, increment);
    }

    @Transactional
    public void incrementS2(String userId, Integer contestId, Short increment) {
        this.currentStandingsRepositoryrepository.incrementS2(userId, contestId, increment);
    }

    @Transactional
    public void incrementS3(String userId, Integer contestId, Short increment) {
        this.currentStandingsRepositoryrepository.incrementS3(userId, contestId, increment);
    }

    @Transactional
    public void incrementS4(String userId, Integer contestId, Short increment) {
        this.currentStandingsRepositoryrepository.incrementS4(userId, contestId, increment);
    }

    @Transactional
    public void rerank(Integer contestId) {
        this.currentStandingsRepositoryrepository.updateRanksBasedOnScore(contestId);
    }
}
