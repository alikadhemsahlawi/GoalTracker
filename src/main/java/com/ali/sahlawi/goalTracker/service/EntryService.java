package com.ali.sahlawi.goalTracker.service;
import com.ali.sahlawi.goalTracker.api.dto.LogEntryRequest;
import com.ali.sahlawi.goalTracker.api.dto.SummaryResponse;
import com.ali.sahlawi.goalTracker.domain.Goal;
import com.ali.sahlawi.goalTracker.domain.ProgressEntry;
import com.ali.sahlawi.goalTracker.repo.GoalRepository;
import com.ali.sahlawi.goalTracker.repo.ProgressEntryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EntryService {
    private final ProgressEntryRepository entries;
    private final GoalRepository goals;

    public EntryService(ProgressEntryRepository entries, GoalRepository goals) {
        this.entries = entries;
        this.goals = goals;
    }

    public ProgressEntry log(UUID goalId, LogEntryRequest req) {
        Goal g = goals.findById(goalId).orElseThrow();
        var e = new ProgressEntry();
        e.setGoal(g);
        e.setEntryDate(req.entryDate());
        e.setAmount(req.amount());
        e.setNote(req.note());
        return entries.save(e);
    }

    public List<ProgressEntry> list(UUID goalId) {
        Goal g = goals.findById(goalId).orElseThrow();
        return entries.findByGoalOrderByEntryDateAsc(g);
    }

    public SummaryResponse summary(UUID goalId) {
        Goal g = goals.findById(goalId).orElseThrow();
        BigDecimal total = entries.sumForGoal(goalId);
        BigDecimal target = g.getTargetAmount();
        BigDecimal remaining = target.subtract(total).max(BigDecimal.ZERO);

        long daysLeft = Math.max(0, ChronoUnit.DAYS.between(LocalDate.now(), g.getEndDate()));
        BigDecimal avgPerDayNeeded = daysLeft == 0
                ? remaining
                : remaining.divide(BigDecimal.valueOf(daysLeft), 3, RoundingMode.HALF_UP);

        double percent = target.signum() == 0
                ? 100.0
                : total.divide(target, 4, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .doubleValue();

        boolean paceOk = daysLeft == 0
                ? remaining.signum() == 0
                : total.compareTo(target) >= 0 || avgPerDayNeeded.doubleValue() <= 0;

        return new SummaryResponse(
                goalId.toString(), target, total, remaining, percent, daysLeft, avgPerDayNeeded, paceOk
        );
    }
}
