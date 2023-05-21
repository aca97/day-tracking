package com.aca.daytracking.mapper;

import com.aca.daytracking.dto.activity.ActivityDTO;
import com.aca.daytracking.dto.day.DayDTO;
import com.aca.daytracking.dto.week.WeekDTO;
import com.aca.daytracking.entity.Activity;
import com.aca.daytracking.entity.Day;
import com.aca.daytracking.entity.Week;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {
    public WeekDTO convertToDTO(Week week) {
        WeekDTO weekDTO = new WeekDTO();
        weekDTO.setId(week.getId());
        weekDTO.setNumber(week.getNumber());
        weekDTO.setCreatedTime(week.getCreatedTime());
        List<DayDTO> dayDTOs = week.getDays().stream()
                .map(this::convertDayToDTO)
                .collect(Collectors.toList());

        weekDTO.setDays(dayDTOs);

        return weekDTO;
    }

    private DayDTO convertDayToDTO(Day day) {
        DayDTO dayDTO = new DayDTO();
        dayDTO.setId(day.getId());
        dayDTO.setName(day.getName());
        dayDTO.setActivities(convertActivityToDTO(day.getActivities()));
        return dayDTO;
    }


    public List<ActivityDTO> convertActivityToDTO(List<Activity> activities) {
        return activities.stream()
                .map(this::convertSingleActivityToDTO)
                .collect(Collectors.toList());
    }

    private ActivityDTO convertSingleActivityToDTO(Activity activity) {
        ActivityDTO activityDTO = new ActivityDTO();
        activityDTO.setId(activity.getId());
        activityDTO.setDescription(activity.getDescription());
        activityDTO.setActivityTime(activity.getActivityTime());

        return activityDTO;
    }

}
