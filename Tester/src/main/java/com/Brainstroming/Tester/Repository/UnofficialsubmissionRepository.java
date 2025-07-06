//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.Brainstroming.Tester.Repository;

import com.Brainstroming.Tester.Entity.UnofficialSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UnofficialsubmissionRepository extends JpaRepository<UnofficialSubmission, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE UnofficialSubmission os SET os.status = :status WHERE os.submissionId = :submissionId")
    void updateStatus(Long submissionId, String status);
}
