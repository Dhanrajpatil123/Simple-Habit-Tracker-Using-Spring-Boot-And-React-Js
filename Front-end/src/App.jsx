// src/App.jsx
import 'bootstrap/dist/css/bootstrap.min.css';
import 'react-toastify/dist/ReactToastify.css';
import { ToastContainer } from 'react-toastify';
import HabitForm from './components/HabitForm';
import HabitList from './components/HabitList';

function App() {
  return (
    <div className="container mt-4">
      <h2 className="text-center mb-4">Simple Habit Tracker</h2>
      <HabitForm onAdd={() => {}} />
      <HabitList />
      <ToastContainer />
    </div>
  );
}

export default App;