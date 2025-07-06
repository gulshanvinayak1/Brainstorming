//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ghanshyam.Brainstroming.Controller;

import com.ghanshyam.Brainstroming.Service.ProblemService;
import com.ghanshyam.Brainstroming.entity.Problem;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/problems"})
public class ProblemController {
    @Autowired
    ProblemService problemService;

    public ProblemController() {
    }

    @GetMapping({"/{id}"})
    public Optional<Problem> getProblemById(@PathVariable String id) {
        return this.problemService.getProblemById(id);
    }

    @GetMapping({"/contest/{contestId}"})
    public List<Problem> getProblemsByContestId(@PathVariable Integer contestId) {
        return this.problemService.getProblemsByContestId(contestId);
    }

    @GetMapping({"/practise/{pageNumber}"})
    public Page<Problem> getProblems(@PathVariable Integer pageNumber) {
        return this.problemService.getProblems(pageNumber);
    }
}
