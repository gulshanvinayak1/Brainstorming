//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ghanshyam.Brainstroming.Service;

import com.ghanshyam.Brainstroming.Repository.OfficialSubmissionRepository;
import com.ghanshyam.Brainstroming.Repository.UnofficialSubmissionRepository;
import com.ghanshyam.Brainstroming.entity.OfficialSubmission;
import com.ghanshyam.Brainstroming.entity.UnofficialSubmission;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SubmissionService {
    @Autowired
    OfficialSubmissionRepository officialSubmissionRepository;
    @Autowired
    UnofficialSubmissionRepository unofficialSubmissionRepository;

    public SubmissionService() {
    }

    public Long savedataofofficialsubmission(OfficialSubmission officialSubmission) {
        return ((OfficialSubmission)this.officialSubmissionRepository.save(officialSubmission)).getSubmissionId();
    }

    public Long savedataofunofficialsubmission(UnofficialSubmission unofficialSubmission) {
        return ((UnofficialSubmission)this.unofficialSubmissionRepository.save(unofficialSubmission)).getSubmissionId();
    }

    public List<OfficialSubmission> officialgetusersSubmissions(String userId, Integer page) {
        Pageable pageable = PageRequest.of(page, 50);
        return this.officialSubmissionRepository.findByUserIdOrderBySubmissionTimeDesc(userId, pageable).getContent();
    }

    public List<OfficialSubmission> officialgetusersSubmissionsofaproblem(String userId, String problemId) {
        return this.officialSubmissionRepository.findByUserIdAndProblemId(userId, problemId);
    }

    public List<UnofficialSubmission> unofficialgetusersSubmissions(String userId, Integer page) {
        Pageable pageable = PageRequest.of(page, 50);
        return this.unofficialSubmissionRepository.findByUserIdOrderBySubmissionTimeDesc(userId, pageable).getContent();
    }

    public List<UnofficialSubmission> unofficialgetusersSubmissionsofaproblem(String userId, String problemId) {
        return this.unofficialSubmissionRepository.findByUserIdAndProblemId(userId, problemId);
    }
}
