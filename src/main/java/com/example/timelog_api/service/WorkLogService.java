package com.example.timelog_api.service;

import com.example.timelog_api.domain.User;
import com.example.timelog_api.domain.WorkLog;
import com.example.timelog_api.repositories.UserRepository;
import com.example.timelog_api.repositories.WorkLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WorkLogService {

    private final WorkLogRepository workLogRepository;
    private final UserRepository userRepository;

    public WorkLogService(UserRepository userRepository, WorkLogRepository workLogRepository) {
        this.userRepository = userRepository;
        this.workLogRepository = workLogRepository;
    }

    public void logStartWork(String cardNumber) {
        User user = userRepository.findUserByCardNumber(cardNumber);

        WorkLog workLog = new WorkLog();
        workLog.setUser(user);
        workLog.setStartTime(LocalDateTime.now());

        workLogRepository.save(workLog);
    }

    public void logEndWork(String cardNumber) {
        User user = userRepository.findUserByCardNumber(cardNumber);

        WorkLog workLog = workLogRepository.findTopByUserOrderByStartTimeDesc(user);

        workLog.setEndTime(LocalDateTime.now());

        workLog.calculateDuration();

        workLogRepository.save(workLog);
    }

    public List<WorkLog> getWorkLogsForUser(String cardNumber) {
        User user = userRepository.findUserByCardNumber(cardNumber);
        return workLogRepository.findAllByUser(user);
    }

}

