package com.aca.daytracking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Week {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(nullable = false)
    private int number;
    @OneToMany(mappedBy = "week", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Day> days = new ArrayList<>();
    private LocalDate createdTime;

    public Week(int number, String name,  List<Day> days) {
        this.number = number;
        this.name = name;
        this.days = days;
        this.createdTime = LocalDate.now();
    }
}
