//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ghanshyam.Brainstroming.Repository;

import com.ghanshyam.Brainstroming.entity.Problem;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, String> {
    Optional<Problem> findById(String id);

    List<Problem> findByContestIdOrderByProblemnumAsc(Integer contestId);

    Page<Problem> findAllByOrderByContestIdDescProblemnumAsc(Pageable pageable);
}
