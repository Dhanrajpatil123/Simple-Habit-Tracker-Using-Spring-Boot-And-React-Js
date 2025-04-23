package com.dhanraj.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhanraj.model.Habit;
import com.dhanraj.model.HabitLog;
import com.dhanraj.service.HabitService;

@RestController
@RequestMapping("/habits")
@CrossOrigin(origins = "*")
public class HabitController {
	
	private final HabitService service;

    public HabitController(HabitService service) {
        this.service = service;
    }

    @PostMapping
    public Habit createHabit(@RequestBody Habit habit) {
        return service.createHabit(habit);
    }

    @GetMapping("/{userId}")
    public List<Habit> getHabitsByUser(@PathVariable Long userId) {
        return service.getHabitsByUserId(userId);
    }

    @PostMapping("/{habitId}/log")
    public HabitLog markDone(@PathVariable Long habitId) {
        return service.markHabitDone(habitId);
    }

    @GetMapping("/{habitId}/logs")
    public List<HabitLog> getLogs(@PathVariable Long habitId) {
        return service.getHabitLogs(habitId);
    }

    @DeleteMapping("/{id}")
    public void deleteHabit(@PathVariable Long id) {
        service.deleteHabit(id);
    }
    
    

}
