package com.example.timelog_api.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "work_log")
public class WorkLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @UuidGenerator
    private UUID id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private Long duration;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void calculateDuration() {
        if (startTime != null && endTime != null) {
            this.duration = Duration.between(startTime, endTime).toMinutes();
        }
    }
}
