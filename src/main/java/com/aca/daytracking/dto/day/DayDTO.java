package com.aca.daytracking.dto.day;

import com.aca.daytracking.dto.activity.ActivityDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DayDTO {
    private Long id;
    private String name;
    private List<ActivityDTO> activities;
}
