package com.aca.daytracking.dto.week;

import com.aca.daytracking.dto.day.DayDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeekDTO {
    private Long id;
    private int number;
    private LocalDate createdTime;
    private List<DayDTO> days;
}
