//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ghanshyam.Brainstroming.Repository;

import com.ghanshyam.Brainstroming.entity.ContestHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContestHistoryRepository extends JpaRepository<ContestHistory, Integer> {
    Page<ContestHistory> findAllByOrderByContestIdDesc(Pageable pageable);
}
