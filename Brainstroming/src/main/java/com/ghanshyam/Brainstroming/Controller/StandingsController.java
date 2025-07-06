//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ghanshyam.Brainstroming.Controller;

import com.ghanshyam.Brainstroming.Service.StandingsService;
import com.ghanshyam.Brainstroming.entity.Standings;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/standings"})
public class StandingsController {
    @Autowired
    StandingsService standingsService;

    public StandingsController() {
    }

    @GetMapping({"/user/{userId}"})
    public List<Standings> getallstandingsofauser(@PathVariable String userId) {
        return this.standingsService.getStandingsByUserId(userId);
    }

    @GetMapping({"/contest/{contestId}/page/{pagenum}"})
    public Page<Standings> getstandingsofacontestbyPage(@PathVariable Integer contestId, @PathVariable Integer pagenum) {
        return this.standingsService.getStandingsByContestId(contestId, pagenum);
    }

    @GetMapping({"/userid/contest/{userId}/{contestId}"})
    public Optional<Standings> getstandingofparticularuserincontest(@PathVariable String userId, @PathVariable Integer contestId) {
        return this.standingsService.getStandingByUserIdAndContestId(userId, contestId);
    }
}
