package com.aca.daytracking.service;

import com.aca.daytracking.entity.Activity;
import com.aca.daytracking.entity.Day;
import com.aca.daytracking.entity.Week;
import com.aca.daytracking.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayService {
    private final DayRepository dayRepository;

    @Autowired
    public DayService(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }

//    public Day createDay(String name, Week week, List<Activity> activities) {
//        Day day = new Day(name, week, activities);
//        return dayRepository.save(day);
//    }
}
