package com.dhanraj.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HabitLog {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private Long habitId;
	
	private LocalDate logDate;
	
	private Boolean completed;

	public HabitLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HabitLog(Long id, Long habitId, LocalDate logDate, Boolean completed) {
		super();
		this.id = id;
		this.habitId = habitId;
		this.logDate = logDate;
		this.completed = completed;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHabitId() {
		return habitId;
	}

	public void setHabitId(Long habitId) {
		this.habitId = habitId;
	}

	public LocalDate getLogDate() {
		return logDate;
	}

	public void setLogDate(LocalDate logDate) {
		this.logDate = logDate;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	
	
	
	
	
	
}
