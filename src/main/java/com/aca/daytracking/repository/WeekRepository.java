package com.aca.daytracking.repository;

import com.aca.daytracking.entity.Week;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeekRepository extends JpaRepository<Week, Long> {
    Week findByNumber(int number);
}
