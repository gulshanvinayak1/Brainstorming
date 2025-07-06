//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ghanshyam.Brainstroming.Service;

import com.ghanshyam.Brainstroming.Repository.ContestHistoryRepository;
import com.ghanshyam.Brainstroming.Repository.UpcomingContestRepository;
import com.ghanshyam.Brainstroming.entity.ContestHistory;
import com.ghanshyam.Brainstroming.entity.UpcomingContest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ContestService {
    @Autowired
    private ContestHistoryRepository contestScheduleRepository;
    @Autowired
    private UpcomingContestRepository upcomingContestRepository;

    public ContestService() {
    }

    public UpcomingContest saveOrUpdateupContest(UpcomingContest contest) {
        return (UpcomingContest)this.upcomingContestRepository.save(contest);
    }

    public List<UpcomingContest> getAllupContests() {
        return this.upcomingContestRepository.findAll();
    }

    public void deleteupcomingContestById(Integer contestId) {
        this.upcomingContestRepository.deleteById(contestId);
    }

    public List<ContestHistory> getpastContests(int pageNumber) {
        int pageSize = 10;
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return this.contestScheduleRepository.findAllByOrderByContestIdDesc(pageRequest).getContent();
    }
}
