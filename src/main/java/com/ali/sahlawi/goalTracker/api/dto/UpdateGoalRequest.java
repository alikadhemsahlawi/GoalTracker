package com.ali.sahlawi.goalTracker.api.dto;

import com.ali.sahlawi.goalTracker.domain.enums.*;

import java.math.BigDecimal;


public record UpdateGoalRequest(
        String title,
        String description,
        Category category,
        Metric metric,
        String unit,
        BigDecimal targetAmount,
        GoalStatus status
) {}
