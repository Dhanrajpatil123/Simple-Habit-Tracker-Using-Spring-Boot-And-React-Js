package com.dhanraj.service;

import java.util.List;

import com.dhanraj.model.Habit;
import com.dhanraj.model.HabitLog;

public interface HabitService {
	
	
	
	Habit createHabit(Habit habit);
    
	List<Habit> getHabitsByUserId(Long userId);
    
	HabitLog markHabitDone(Long habitId);
    
	List<HabitLog> getHabitLogs(Long habitId);
    
	void deleteHabit(Long habitId);

}
