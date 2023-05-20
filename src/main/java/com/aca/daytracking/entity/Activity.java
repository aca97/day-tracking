package com.aca.daytracking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String description;
    @Column(name = "activity_time")
    private LocalTime activityTime;
    @ManyToOne
    @JoinColumn(name = "day_id", nullable = false)
//    @JsonIgnore
    private Day day;

    public Activity(String description, Day day) {
        this.description = description;
        this.activityTime = LocalTime.now();
        this.day = day;
    }
}
