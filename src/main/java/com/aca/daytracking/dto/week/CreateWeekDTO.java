package com.aca.daytracking.dto.week;

import com.aca.daytracking.dto.day.DayDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateWeekDTO {
    private int number;
}