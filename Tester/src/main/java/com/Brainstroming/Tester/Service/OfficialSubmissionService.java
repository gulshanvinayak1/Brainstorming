//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.Brainstroming.Tester.Service;

import com.Brainstroming.Tester.Repository.OfficialSubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class OfficialSubmissionService {
    @Autowired
    private OfficialSubmissionRepository officialsubmissionRepository;

    public OfficialSubmissionService() {
    }

    @Async
    public boolean updateSubmissionStatus(Long submissionId, String newStatus) {
        try {
            this.officialsubmissionRepository.updateStatus(submissionId, newStatus);
            return true;
        } catch (Exception var4) {
            Exception e = var4;
            e.printStackTrace();
            return false;
        }
    }
}
