package com.aca.daytracking.controller;

import com.aca.daytracking.dto.week.CreateWeekDTO;
import com.aca.daytracking.dto.week.WeekDTO;
import com.aca.daytracking.entity.Week;
import com.aca.daytracking.service.WeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/weeks")
public class WeekController {
    private final WeekService weekService;

    @Autowired
    public WeekController(WeekService weekService) {
        this.weekService = weekService;
    }

    @PostMapping
    public ResponseEntity<Week> createWeek(@RequestBody CreateWeekDTO request) {
        int number = request.getNumber();
        Week week = weekService.createWeek(number);
        return new ResponseEntity<>(week, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Week>> getAllWeeks() {
        List<Week> weeks = weekService.findAllWeeks();
        return new ResponseEntity<>(weeks, HttpStatus.OK);
    }

    @GetMapping("/{weekNumber}")
    public WeekDTO getWeekByNumber(@PathVariable int weekNumber) {
        return weekService.findWeekByNumber(weekNumber);
    }
}