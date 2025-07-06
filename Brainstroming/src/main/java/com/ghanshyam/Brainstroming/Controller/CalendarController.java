//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ghanshyam.Brainstroming.Controller;

import com.ghanshyam.Brainstroming.Service.ContestService;
import com.ghanshyam.Brainstroming.entity.ContestHistory;
import com.ghanshyam.Brainstroming.entity.UpcomingContest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/Calendar"})
public class CalendarController {
    @Autowired
    ContestService contestService;

    public CalendarController() {
    }

    @GetMapping({"/past/{pageno}"})
    public List<ContestHistory> getpastcontests(@PathVariable Integer pageno) {
        return this.contestService.getpastContests(pageno);
    }

    @GetMapping({"/upcoming"})
    public List<UpcomingContest> getupcomingcontest() {
        return this.contestService.getAllupContests();
    }

    @PostMapping({"/upcoming"})
    public void addupcomingcontest(@RequestBody UpcomingContest upcomingContest) {
        this.contestService.saveOrUpdateupContest(upcomingContest);
    }

    @DeleteMapping({"/upcoming/{contesId}"})
    public void cancelcontest(@PathVariable Integer contestId) {
        this.contestService.deleteupcomingContestById(contestId);
    }
}
