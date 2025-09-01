package com.ali.sahlawi.goalTracker.service;

import com.ali.sahlawi.goalTracker.api.dto.CreateGoalRequest;
import com.ali.sahlawi.goalTracker.api.dto.UpdateGoalRequest;
import com.ali.sahlawi.goalTracker.domain.Goal;
import com.ali.sahlawi.goalTracker.repo.GoalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GoalService {

    private final GoalRepository goalRepository;

    public GoalService(GoalRepository goalsRepository) {
        this.goalRepository = goalsRepository;

    }

    public Goal create(CreateGoalRequest req) {

        Goal g = new Goal();
        g.setTitle(req.title());
        g.setDescription(req.description());
        g.setCategory(req.category());
        g.setMetric(req.metric());
        g.setUnit(req.unit());
        g.setTargetAmount(req.targetAmount());
        g.setPeriodGranularity(req.periodGranularity());
        g.setPeriodYear(req.periodYear());
        g.setPeriodMonth(req.periodMonth());
        g.setPeriodWeek(req.periodWeek());
        g.setStartDate(req.startDate());
        g.setEndDate(req.endDate());
        return goalRepository.save(g);
    }


    public Goal get(UUID id) {
        return goalRepository.findById(id).orElseThrow();
    }

    public List<Goal> getAll() {
        return goalRepository.findAll();
    }

    public Goal update(UUID id, UpdateGoalRequest req) {
        Goal goal = get(id);
        if (req.title() != null) goal.setTitle(req.title());
        if (req.description() != null) goal.setDescription(req.description());
        if (req.category() != null) goal.setCategory(req.category());
        if (req.metric() != null) goal.setMetric(req.metric());
        if (req.unit() != null) goal.setUnit(req.unit());
        if (req.targetAmount() != null) goal.setTargetAmount(req.targetAmount());
        if (req.status() != null) goal.setStatus(req.status());
        return goal; // JPA dirty-check will auto-update
    }

    public void delete(UUID id) {
        goalRepository.deleteById(id);
    }
}
