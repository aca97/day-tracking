package com.aca.daytracking.service;

import com.aca.daytracking.dto.week.WeekDTO;
import com.aca.daytracking.entity.Day;
import com.aca.daytracking.entity.Week;
import com.aca.daytracking.exception.WeekAlreadyExistException;
import com.aca.daytracking.mapper.Mapper;
import com.aca.daytracking.repository.DayRepository;
import com.aca.daytracking.repository.WeekRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class WeekService {
    private final WeekRepository weekRepository;
    private final Mapper mapper;

    @Autowired
    public WeekService(WeekRepository weekRepository, Mapper mapper) {
        this.weekRepository = weekRepository;
        this.mapper = mapper;
    }

    public List<Week> findAllWeeks() {
        return weekRepository.findAll();
    }

    public WeekDTO findWeekByNumber(int weekNumber) {
        Week week = weekRepository.findByNumber(weekNumber);
        return mapper.convertToDTO(week);
    }

    public Week createWeek(int number) {
        Week existingWeek = weekRepository.findByNumber(number);
        if (existingWeek != null) {
            throw new WeekAlreadyExistException("Week number already exists: " + number);
        }
        Week week = new Week();
        week.setNumber(number);
        week.setName("Week");
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            Day day = new Day();
            day.setName(dayOfWeek.toString());
            day.setWeek(week);
            week.getDays().add(day);
        }
        week.setCreatedTime(LocalDate.now()); // Set the creation time

        return weekRepository.save(week);
    }
}
