package com.ali.sahlawi.goalTracker.api.dto;

import com.ali.sahlawi.goalTracker.domain.enums.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;


public record CreateGoalRequest(
        @NotBlank String title,
        String description,
        @NotNull Category category,
        @NotNull Metric metric,
        @NotBlank String unit,
        @NotNull @DecimalMin("0.0") BigDecimal targetAmount,
        @NotNull PeriodGranularity periodGranularity,
        @NotNull Integer periodYear,
        Integer periodMonth,
        Integer periodWeek,
        @NotNull LocalDate startDate,
        @NotNull LocalDate endDate
) {}