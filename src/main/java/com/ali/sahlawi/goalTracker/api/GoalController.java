package com.ali.sahlawi.goalTracker.api;

import com.ali.sahlawi.goalTracker.api.dto.CreateGoalRequest;
import com.ali.sahlawi.goalTracker.api.dto.UpdateGoalRequest;
import com.ali.sahlawi.goalTracker.domain.Goal;
import com.ali.sahlawi.goalTracker.service.GoalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/goals")
public class GoalController {

    private final GoalService service;

    public GoalController(GoalService service) {
        this.service = service;
    }

    // Create a new goal for a specific user
    @PostMapping("")
    public ResponseEntity<Goal> create(@RequestBody CreateGoalRequest req) {
        return ResponseEntity.ok(service.create(req));
    }




    @GetMapping("")
    public ResponseEntity<List<Goal>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // Get a goal by its ID
    @GetMapping("/goal/{id}")
    public ResponseEntity<Goal> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.get(id));
    }

    // Update a goal by its ID
    @PutMapping("/goal/{id}")
    public ResponseEntity<Goal> update(@PathVariable UUID id, @RequestBody UpdateGoalRequest req) {
        return ResponseEntity.ok(service.update(id, req));
    }

    // Delete a goal by its ID
    @DeleteMapping("/goal/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
