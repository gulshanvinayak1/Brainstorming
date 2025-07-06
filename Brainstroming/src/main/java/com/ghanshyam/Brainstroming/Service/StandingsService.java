//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ghanshyam.Brainstroming.Service;

import com.ghanshyam.Brainstroming.Repository.StandingsRepository;
import com.ghanshyam.Brainstroming.entity.Standings;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StandingsService {
    @Autowired
    StandingsRepository standingsRepository;

    public StandingsService() {
    }

    public List<Standings> getStandingsByUserId(String userId) {
        return this.standingsRepository.findByUserId(userId);
    }

    public Page<Standings> getStandingsByContestId(Integer contestId, Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 50);
        return this.standingsRepository.findByContestId(contestId, pageable);
    }

    public Optional<Standings> getStandingByUserIdAndContestId(String userId, Integer contestId) {
        return this.standingsRepository.findByUserIdAndContestId(userId, contestId);
    }
}
