package com.aca.daytracking.service;

import com.aca.daytracking.entity.Activity;
import com.aca.daytracking.entity.Day;
import com.aca.daytracking.exception.NotFoundException;
import com.aca.daytracking.repository.ActivityRepository;
import com.aca.daytracking.repository.DayRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final DayRepository dayRepository;
    public ActivityService(ActivityRepository activityRepository, DayRepository dayRepository) {
        this.activityRepository = activityRepository;
        this.dayRepository = dayRepository;
    }

    public Activity createActivity(Activity activity) {
        Day day = dayRepository.findById(activity.getDay().getId())
                .orElseThrow(() -> new NotFoundException("Day not found: " + activity.getDay().getId()));

        activity.setActivityTime(LocalTime.now());
        activity.setDescription(activity.getDescription());
        activity.setDay(day);
        
        return activityRepository.save(activity);
    }
}
