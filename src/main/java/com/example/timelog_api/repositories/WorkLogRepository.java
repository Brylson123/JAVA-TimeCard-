package com.example.timelog_api.repositories;

import com.example.timelog_api.domain.User;
import com.example.timelog_api.domain.WorkLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface WorkLogRepository extends JpaRepository<WorkLog, UUID> {
    WorkLog findTopByUserOrderByStartTimeDesc(User user);

    List<WorkLog> findAllByUser(User user);
}
