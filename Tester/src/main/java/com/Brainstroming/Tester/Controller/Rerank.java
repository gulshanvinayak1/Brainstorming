//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.Brainstroming.Tester.Controller;

import com.Brainstroming.Tester.Service.CurrentStandingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rerank {
    @Autowired
    CurrentStandingsService currentStandingsService;

    public Rerank() {
    }

    @PostMapping({"/rerank/{contestId}"})
    public void rerank(@PathVariable Integer contestId) {
        this.currentStandingsService.rerank(contestId);
    }
}
