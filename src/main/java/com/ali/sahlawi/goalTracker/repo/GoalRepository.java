package com.ali.sahlawi.goalTracker.repo;

import com.ali.sahlawi.goalTracker.domain.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GoalRepository extends JpaRepository<Goal, UUID> {

}
