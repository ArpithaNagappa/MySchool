import { useState } from "react";
import api from "../services/api";

export default function Register() {
  const [form, setForm] = useState({});

  const register = async (e) => {
    e.preventDefault();
    await api.post("/auth/register", form);
    alert("Registered successfully");
  };

  return (
    <form onSubmit={register}>
      <h2>Register</h2>
      <input placeholder="Name" onChange={e => setForm({...form, name: e.target.value})} />
      <input placeholder="Email" onChange={e => setForm({...form, email: e.target.value})} />
      <input type="password" placeholder="Password" onChange={e => setForm({...form, password: e.target.value})} />
      <button type="submit">Register</button>
    </form>
  );
}
