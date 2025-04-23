package com.dhanraj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhanraj.model.HabitLog;

public interface HabitLogRepository extends JpaRepository<HabitLog, Long>{

	
	List<HabitLog> findByHabitId(Long habitId);
    
	HabitLog findByHabitIdAndLogDate(Long habitId, java.time.LocalDate logDate);
	
}
