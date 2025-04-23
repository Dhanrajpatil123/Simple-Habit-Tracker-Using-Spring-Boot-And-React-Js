import { useEffect, useState } from "react";
import { getHabitsByUser, markHabitAsDone, deleteHabit } from "../services/api";
import { toast } from "react-toastify";

const HabitList = () => {
  const [habits, setHabits] = useState([]);

  const fetchHabits = async () => {
    try {
      const res = await getHabitsByUser(1);
      if (Array.isArray(res.data)) {
        setHabits(res.data);
      } else if (Array.isArray(res.data.habits)) {
        setHabits(res.data.habits);
      } else {
        toast.error("Unexpected data format");
      }
    } catch (err) {
      toast.error("Failed to fetch habits");
    }
  };

  useEffect(() => {
    fetchHabits();
  }, []);

  const handleMarkDone = async (id) => {
    try {
      await markHabitAsDone(id);
      toast.success("Marked as done!");
      fetchHabits();
    } catch (err) {
      toast.error("Could not mark as done");
    }
  };

  const handleDelete = async (id) => {
    try {
      await deleteHabit(id);
      toast.success("Habit deleted");
      fetchHabits();
    } catch (err) {
      toast.error("Delete failed");
    }
  };

  return (
    <div>
      {habits.length === 0 ? (
        <p className="text-center mt-3 text-muted">No habits found</p>
      ) : (
        habits.map((habit) => (
          <div className="card mb-2" key={habit.id}>
            <div className="card-body d-flex justify-content-between align-items-center">
              <span>{habit.habitName || habit.name || "Untitled Habit"}</span>
              <div>
                {habit.done ? (
                  <button
                    className="btn btn-outline-success btn-sm me-2"
                    disabled
                  >
                    ✅ Done
                  </button>
                ) : (
                  <button
                    className="btn btn-success btn-sm me-2"
                    onClick={() => handleMarkDone(habit.id)}
                  >
                    Mark as Done
                  </button>
                )}
                <button
                  className="btn btn-danger btn-sm"
                  onClick={() => handleDelete(habit.id)}
                >
                  Delete
                </button>
              </div>
            </div>
          </div>
        ))
      )}
    </div>
  );
};

export default HabitList;
