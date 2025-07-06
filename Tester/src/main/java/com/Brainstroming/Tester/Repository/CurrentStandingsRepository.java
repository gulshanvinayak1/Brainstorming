//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.Brainstroming.Tester.Repository;

import com.Brainstroming.Tester.Entity.CurrentStandings;
import com.Brainstroming.Tester.Entity.StandingsId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentStandingsRepository extends JpaRepository<CurrentStandings, StandingsId> {
    @Modifying
    @Transactional
    @Query("UPDATE CurrentStandings cs SET cs.s1 = cs.s1 + :increment WHERE cs.userId = :userId AND cs.contestId = :contestId")
    void incrementS1(String userId, Integer contestId, Short increment);

    @Modifying
    @Transactional
    @Query("UPDATE CurrentStandings cs SET cs.s2 = cs.s2 + :increment WHERE cs.userId = :userId AND cs.contestId = :contestId")
    void incrementS2(String userId, Integer contestId, Short increment);

    @Modifying
    @Transactional
    @Query("UPDATE CurrentStandings cs SET cs.s3 = cs.s3 + :increment WHERE cs.userId = :userId AND cs.contestId = :contestId")
    void incrementS3(String userId, Integer contestId, Short increment);

    @Modifying
    @Transactional
    @Query("UPDATE CurrentStandings cs SET cs.s4 = cs.s4 + :increment WHERE cs.userId = :userId AND cs.contestId = :contestId")
    void incrementS4(String userId, Integer contestId, Short increment);

    @Modifying
    @Transactional
    @Query(
            value = "WITH RankedStandings AS (\n    SELECT\n        user_id,\n        contest_id,\n        RANK() OVER (ORDER BY (s1 + s2 + s3 + s4) DESC) AS ranks\n    FROM\n        currentstandings\n    WHERE\n        contest_id = :contestId\n)\nUPDATE currentstandings cs\nJOIN RankedStandings rs\nON cs.user_id = rs.user_id AND cs.contest_id = rs.contest_id\nSET cs.ranking = rs.ranks\n",
            nativeQuery = true
    )
    void updateRanksBasedOnScore(Integer contestId);
}
