import { useState } from "react";
import { createHabit } from "../services/api";
import { toast } from "react-toastify";

const HabitForm = ({ onAdd }) => {
  const [habitName, setHabitName] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!habitName.trim()) return;

    try {
      const res = await createHabit({ userId: 1, habitName });
      onAdd(res.data);
      toast.success("Habit added!");
      setHabitName("");
    } catch (err) {
      toast.error("Failed to add habit");
    }
  };

  return (
    <form onSubmit={handleSubmit} className="mb-4">
      <div className="input-group">
        <input
          type="text"
          className="form-control"
          placeholder="Enter new habit"
          value={habitName}
          onChange={(e) => setHabitName(e.target.value)}
        />
        <button type="submit" className="btn btn-primary">
          Add
        </button>
      </div>
    </form>
  );
};

export default HabitForm;
