package com.ali.sahlawi.goalTracker.repo;

import com.ali.sahlawi.goalTracker.domain.Goal;
import com.ali.sahlawi.goalTracker.domain.ProgressEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


public interface ProgressEntryRepository extends JpaRepository<ProgressEntry, UUID> {
    List<ProgressEntry> findByGoalOrderByEntryDateAsc(Goal goal);


    @Query("select coalesce(sum(p.amount), 0) from ProgressEntry p where p.goal.id = :goalId")
    BigDecimal sumForGoal(UUID goalId);
}