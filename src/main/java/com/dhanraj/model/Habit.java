package com.dhanraj.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Habit {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private Long userId;
	
	private String habitName;
	
	private LocalDateTime creDateTime = LocalDateTime.now();

	public Habit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Habit(Long id, Long userId, String habitName, LocalDateTime creDateTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.habitName = habitName;
		this.creDateTime = creDateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getHabitName() {
		return habitName;
	}

	public void setHabitName(String habitName) {
		this.habitName = habitName;
	}

	public LocalDateTime getCreDateTime() {
		return creDateTime;
	}

	public void setCreDateTime(LocalDateTime creDateTime) {
		this.creDateTime = creDateTime;
	}
	
	
	
	
}
