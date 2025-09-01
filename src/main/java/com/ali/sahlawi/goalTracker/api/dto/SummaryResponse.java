package com.ali.sahlawi.goalTracker.api.dto;

import java.math.BigDecimal;


public record SummaryResponse(
        String goalId,
        BigDecimal target,
        BigDecimal total,
        BigDecimal remaining,
        double percent,
        long daysLeft,
        BigDecimal avgPerDayNeeded,
        boolean paceOk
) {}