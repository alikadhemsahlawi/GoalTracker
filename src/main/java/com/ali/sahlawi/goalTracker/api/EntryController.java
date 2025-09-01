package com.ali.sahlawi.goalTracker.api;

import com.ali.sahlawi.goalTracker.api.dto.LogEntryRequest;
import com.ali.sahlawi.goalTracker.api.dto.SummaryResponse;
import com.ali.sahlawi.goalTracker.domain.ProgressEntry;
import com.ali.sahlawi.goalTracker.service.EntryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/goals/{goalId}/entries")
public class EntryController {
    private final EntryService entries;


    public EntryController(EntryService entries) {
        this.entries = entries;
    }


    @PostMapping
    public ResponseEntity<ProgressEntry> log(@PathVariable UUID goalId, @RequestBody LogEntryRequest req) {
        return ResponseEntity.ok(entries.log(goalId, req));
    }


    @GetMapping
    public List<ProgressEntry> list(@PathVariable UUID goalId) {
        return entries.list(goalId);
    }


    @GetMapping("/summary")
    public SummaryResponse summary(@PathVariable UUID goalId) {
        return entries.summary(goalId);
    }
}