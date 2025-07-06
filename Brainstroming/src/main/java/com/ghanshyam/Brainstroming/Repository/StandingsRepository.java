//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ghanshyam.Brainstroming.Repository;

import com.ghanshyam.Brainstroming.entity.Standings;
import java.util.List;
import java.util.Optional;

import com.ghanshyam.Brainstroming.entity.StandingsId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandingsRepository extends JpaRepository<Standings, StandingsId> {
    List<Standings> findByUserId(String userId);

    Page<Standings> findByContestId(Integer contestId, Pageable pageable);

    Optional<Standings> findByUserIdAndContestId(String userId, Integer contestId);
}
