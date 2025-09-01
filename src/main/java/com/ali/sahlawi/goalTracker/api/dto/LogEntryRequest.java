package com.ali.sahlawi.goalTracker.api.dto;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;


public record LogEntryRequest(
        @NotNull LocalDate entryDate,
        @NotNull @DecimalMin("0.0") BigDecimal amount,
        String note
) {}
