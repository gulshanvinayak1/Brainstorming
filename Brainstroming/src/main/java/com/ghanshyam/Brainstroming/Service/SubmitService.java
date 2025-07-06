package com.ghanshyam.Brainstroming.Service;

import com.ghanshyam.Brainstroming.Collection.OfficialCode;
import com.ghanshyam.Brainstroming.Collection.UnofficialCode;
import com.ghanshyam.Brainstroming.Dto.ConvertDto;
import com.ghanshyam.Brainstroming.Dto.SubmissionDto;
import com.ghanshyam.Brainstroming.entity.OfficialSubmission;
import com.ghanshyam.Brainstroming.entity.UnofficialSubmission;
import com.ghanshyam.Brainstroming.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmitService {
    @Autowired
    KafkaProducer kafkaProducer;
    @Autowired
    UnofficialSubmission unofficialSubmission;
    @Autowired
    OfficialSubmission officialSubmission;
    @Autowired
    OfficialCode officialCode;
    @Autowired
    UnofficialCode unofficialCode;
    @Autowired
    SubmissionService submissionService;
    @Autowired
    CodeService codeService;

    public SubmitService() {
    }

    public void submit(SubmissionDto submissionDto) {
        Integer var10000 = submissionDto.getContestId();
        String problemId = "" + var10000 + "$" + submissionDto.getProblemnum();
        System.out.println(submissionDto.toString());
        long submissionsId;
        if (submissionDto.getScore() != 0) {
            this.officialSubmission.setProblemId(problemId);
            this.officialSubmission.setLanguage(submissionDto.getLanguage());
            this.officialSubmission.setSubmissionTime(submissionDto.getSubmissionTime());
            this.officialSubmission.setStatus(submissionDto.getStatus());
            this.officialSubmission.setUserId(submissionDto.getUserId());
            submissionsId = this.submissionService.savedataofofficialsubmission(this.officialSubmission);
            this.officialCode.setSubmissionId(submissionsId);
            this.officialCode.setCode(submissionDto.getCode());
            this.kafkaProducer.sendmessage(ConvertDto.convertToObject(submissionDto, submissionsId));
            this.codeService.saveOfficial(this.officialCode);
        } else {
            this.unofficialSubmission.setProblemId(problemId);
            this.unofficialSubmission.setLanguage(submissionDto.getLanguage());
            this.unofficialSubmission.setSubmissionTime(submissionDto.getSubmissionTime());
            this.unofficialSubmission.setStatus(submissionDto.getStatus());
            this.unofficialSubmission.setUserId(submissionDto.getUserId());
            submissionsId = this.submissionService.savedataofunofficialsubmission(this.unofficialSubmission);
            this.unofficialCode.setSubmissionId(submissionsId);
            this.unofficialCode.setCode(submissionDto.getCode());
            this.kafkaProducer.sendmessage(ConvertDto.convertToObject(submissionDto, submissionsId));
            this.codeService.saveUnofficial(this.unofficialCode);
            System.out.println("added");
        }

    }
}
