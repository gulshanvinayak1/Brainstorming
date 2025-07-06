//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ghanshyam.Brainstroming.Repository;

import com.ghanshyam.Brainstroming.entity.UnofficialSubmission;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnofficialSubmissionRepository extends JpaRepository<UnofficialSubmission, Long> {
    Page<UnofficialSubmission> findByUserIdOrderBySubmissionTimeDesc(String userId, Pageable pageable);

    List<UnofficialSubmission> findByUserIdAndProblemId(String userId, String problemId);
}
