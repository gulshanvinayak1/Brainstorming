//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ghanshyam.Brainstroming.Controller;

import com.ghanshyam.Brainstroming.Dto.SubmissionDto;
import com.ghanshyam.Brainstroming.Service.CodeService;
import com.ghanshyam.Brainstroming.Service.SubmissionService;
import com.ghanshyam.Brainstroming.Service.SubmitService;
import com.ghanshyam.Brainstroming.entity.OfficialSubmission;
import com.ghanshyam.Brainstroming.entity.UnofficialSubmission;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Submitcontroller {
    @Autowired
    SubmitService submitService;
    @Autowired
    SubmissionService submissionService;
    @Autowired
    CodeService codeService;

    public Submitcontroller() {
    }

    @PostMapping({"/submit"})
    public void submit(@RequestBody SubmissionDto submissionDto) {
        System.out.println("i am called");
        this.submitService.submit(submissionDto);
    }

    @GetMapping({"/getofficialsubmissionsofuser/{userId}/page/{page}"})
    public List<OfficialSubmission> getofficialsubmissions(@PathVariable String userId, @PathVariable Integer page) {
        return this.submissionService.officialgetusersSubmissions(userId, page);
    }

    @GetMapping({"/getofficialsubmissionsofuserofaquestion/{userId}/problemId/{problemId}"})
    public List<OfficialSubmission> getofficialsubmissionsofaquestion(@PathVariable String userId, @PathVariable String problemId) {
        return this.submissionService.officialgetusersSubmissionsofaproblem(userId, problemId);
    }

    @GetMapping({"/getunofficialsubmissionsofuser/{userId}/page/{page}"})
    public List<UnofficialSubmission> getunofficialsubmissions(@PathVariable String userId, @PathVariable Integer page) {
        return this.submissionService.unofficialgetusersSubmissions(userId, page);
    }

    @GetMapping({"/getunofficialsubmissionsofuserofaquestion/{userId}/problemId/{problemId}"})
    public List<UnofficialSubmission> getunofficialsubmissionsofaquestion(@PathVariable String userId, @PathVariable String problemId) {
        return this.submissionService.unofficialgetusersSubmissionsofaproblem(userId, problemId);
    }

    @GetMapping({"/getcodeofficial/{submissionid}"})
    public String getofficialcode(@PathVariable Long submissionId) {
        return this.codeService.getofficialcode(submissionId);
    }

    @GetMapping({"/getcodeunofficial/{submissionid}"})
    public String getunofficialcode(@PathVariable Long submissionId) {
        return this.codeService.getunofficialcode(submissionId);
    }
}
