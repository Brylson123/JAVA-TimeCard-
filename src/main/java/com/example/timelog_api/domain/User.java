package com.example.timelog_api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    @Size(min = 3, max = 51)
    private String username;

    @Size(min = 10, max = 10)
    private String cardNumber;

    private UserRole userRole;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<WorkLog> workLogs;

    public User(String username, String cardNumber) {
        this.username = username;
        this.cardNumber = cardNumber;
    }
}
