package com.dhanraj.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dhanraj.model.Habit;
import com.dhanraj.model.HabitLog;
import com.dhanraj.repository.HabitLogRepository;
import com.dhanraj.repository.HabitRepository;


@Service
public class HabitServiceImpl implements HabitService{
	
	
	 private final HabitRepository habitRepo;
	    private final HabitLogRepository logRepo;

	    public HabitServiceImpl(HabitRepository habitRepo, HabitLogRepository logRepo) {
	        this.habitRepo = habitRepo;
	        this.logRepo = logRepo;
	    }

	    @Override
	    public Habit createHabit(Habit habit) {
	        return habitRepo.save(habit);
	    }

	    @Override
	    public List<Habit> getHabitsByUserId(Long userId) {
	        return habitRepo.findByUserId(userId);
	    }

	    @Override
	    public HabitLog markHabitDone(Long habitId) {
	        LocalDate today = LocalDate.now();
	        HabitLog log = logRepo.findByHabitIdAndLogDate(habitId, today);
	        if (log == null) {
	            log = new HabitLog();
	            log.setHabitId(habitId);
	            log.setLogDate(today);
	            log.setCompleted(true);
	        } else {
	            log.setCompleted(true);
	        }
	        return logRepo.save(log);
	    }

	    @Override
	    public List<HabitLog> getHabitLogs(Long habitId) {
	        return logRepo.findByHabitId(habitId);
	    }

	    @Override
	    public void deleteHabit(Long habitId) {
	        habitRepo.deleteById(habitId);
	    }
	    
	    

}
