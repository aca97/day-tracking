package com.aca.daytracking.repository;

import com.aca.daytracking.entity.Day;
import com.aca.daytracking.entity.Week;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayRepository extends JpaRepository<Day, Long> {
    Day findDayById(Long id);

}
