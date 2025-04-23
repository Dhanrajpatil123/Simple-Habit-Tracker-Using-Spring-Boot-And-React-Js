// src/services/api.js
import axios from 'axios';

const BASE_URL = 'http://localhost:8080';

export const createHabit = (habit) => axios.post(`${BASE_URL}/habits`, habit);

export const getHabitsByUser = (userId) => axios.get(`${BASE_URL}/habits/${userId}`);

export const markHabitAsDone = (habitId) => axios.post(`${BASE_URL}/habits/${habitId}/log`);

export const deleteHabit = (habitId) => axios.delete(`${BASE_URL}/habits/${habitId}`);
