import { useState } from "react";
import api from "../services/api";

export default function Contact() {
  const [msg, setMsg] = useState("");

  const sendMessage = async (e) => {
    e.preventDefault();
    await api.post("/contact", { message: msg });
    alert("Message sent");
  };

  return (
    <form onSubmit={sendMessage}>
      <h2>Contact Us</h2>
      <textarea onChange={e => setMsg(e.target.value)} />
      <button type="submit">Send</button>
    </form>
  );
}
