//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ghanshyam.Brainstroming.Service;

import com.ghanshyam.Brainstroming.Repository.ProblemRepository;
import com.ghanshyam.Brainstroming.entity.Problem;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProblemService {
    @Autowired
    ProblemRepository problemRepository;

    public ProblemService() {
    }

    public Optional<Problem> getProblemById(String id) {
        return this.problemRepository.findById(id);
    }

    public List<Problem> getProblemsByContestId(Integer contestId) {
        return this.problemRepository.findByContestIdOrderByProblemnumAsc(contestId);
    }

    public Page<Problem> getProblems(Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 50);
        return this.problemRepository.findAllByOrderByContestIdDescProblemnumAsc(pageable);
    }
}
