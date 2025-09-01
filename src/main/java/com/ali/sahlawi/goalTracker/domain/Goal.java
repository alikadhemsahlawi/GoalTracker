package com.ali.sahlawi.goalTracker.domain;

import com.ali.sahlawi.goalTracker.domain.enums.Category;
import com.ali.sahlawi.goalTracker.domain.enums.GoalStatus;
import com.ali.sahlawi.goalTracker.domain.enums.Metric;
import com.ali.sahlawi.goalTracker.domain.enums.PeriodGranularity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;



@Entity
@Table(name = "goals")
public class Goal {
    @Id
    private UUID id = UUID.randomUUID();

    private String title;
    private String description;


    @Enumerated(EnumType.STRING)
    private Category category;


    @Enumerated(EnumType.STRING)
    private Metric metric;


    private String unit;


    @Column(precision = 12, scale = 2, nullable = false)
    private BigDecimal targetAmount;


    @Enumerated(EnumType.STRING)
    private PeriodGranularity periodGranularity;


    private int periodYear;
    private Integer periodMonth; // 1-12
    private Integer periodWeek; // ISO week 1-53


    private LocalDate startDate;
    private LocalDate endDate;


    @Enumerated(EnumType.STRING)
    private GoalStatus status = GoalStatus.ACTIVE;


    private OffsetDateTime createdAt = OffsetDateTime.now();
    private OffsetDateTime updatedAt = OffsetDateTime.now();


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Metric getMetric() {
        return metric;
    }

    public void setMetric(Metric metric) {
        this.metric = metric;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(BigDecimal targetAmount) {
        this.targetAmount = targetAmount;
    }

    public PeriodGranularity getPeriodGranularity() {
        return periodGranularity;
    }

    public void setPeriodGranularity(PeriodGranularity periodGranularity) {
        this.periodGranularity = periodGranularity;
    }

    public int getPeriodYear() {
        return periodYear;
    }

    public void setPeriodYear(int periodYear) {
        this.periodYear = periodYear;
    }

    public Integer getPeriodMonth() {
        return periodMonth;
    }

    public void setPeriodMonth(Integer periodMonth) {
        this.periodMonth = periodMonth;
    }

    public Integer getPeriodWeek() {
        return periodWeek;
    }

    public void setPeriodWeek(Integer periodWeek) {
        this.periodWeek = periodWeek;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public GoalStatus getStatus() {
        return status;
    }

    public void setStatus(GoalStatus status) {
        this.status = status;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}