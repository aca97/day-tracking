package com.aca.daytracking.service;

import com.aca.daytracking.dto.activity.ActivityDTO;
import com.aca.daytracking.entity.Activity;
import com.aca.daytracking.entity.Day;
import com.aca.daytracking.exception.NotFoundException;
import com.aca.daytracking.mapper.Mapper;
import com.aca.daytracking.repository.ActivityRepository;
import com.aca.daytracking.repository.DayRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final DayRepository dayRepository;
    private final Mapper mapper;

    public ActivityService(ActivityRepository activityRepository, DayRepository dayRepository, Mapper mapper) {
        this.activityRepository = activityRepository;
        this.dayRepository = dayRepository;
        this.mapper = mapper;
    }

    public Activity createActivity(Activity activity) {
        Day day = dayRepository.findById(activity.getDay().getId())
                .orElseThrow(() -> new NotFoundException("Day not found: " + activity.getDay().getId()));

        activity.setActivityTime(LocalTime.now());
        activity.setDescription(activity.getDescription());
        activity.setDay(day);
        
        return activityRepository.save(activity);
    }

    public List<ActivityDTO> getAllActivitiesForTheDay(Long dayId) {
        Day day = dayRepository.findById(dayId)
                .orElseThrow(() -> new NotFoundException("Day with id not found: " + dayId));
        List<Activity> activities = day.getActivities();
        return mapper.convertActivityToDTO(activities);
    }

//    public WeekDTO findWeekByNumber(int weekNumber) {
//        Week week = weekRepository.findByNumber(weekNumber);
//        return mapper.convertToDTO(week);
//    }
}
