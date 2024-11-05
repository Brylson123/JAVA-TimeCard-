package com.example.timelog_api.controller;

import com.example.timelog_api.domain.WorkLog;
import com.example.timelog_api.service.WorkLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/worklog")
public class WorkLogController {

    private final WorkLogService workLogService;

    public WorkLogController(WorkLogService workLogService) {
        this.workLogService = workLogService;
    }

    @PostMapping("/start/{cardNumber}")
    public ResponseEntity<String> startWork(@PathVariable String cardNumber) {
        try {
            workLogService.logStartWork(cardNumber);
            return ResponseEntity.ok("Work started successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error starting work: " + e.getMessage());
        }
    }

    @PostMapping("/end/{cardNumber}")
    public ResponseEntity<String> endWork(@PathVariable String cardNumber) {
        try {
            workLogService.logEndWork(cardNumber);
            return ResponseEntity.ok("Work ended successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error ending work: " + e.getMessage());
        }
    }
        @GetMapping("/logs/{cardNumber}")
        public ResponseEntity<List<WorkLog>> getWorkLogs(@PathVariable String cardNumber) {
            try {
                List<WorkLog> workLogs = workLogService.getWorkLogsForUser(cardNumber);
                return ResponseEntity.ok(workLogs);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(null);
            }
        }
}
