import React from "react";
import { Link } from "react-router-dom";

function Header() {
  return (
    <nav style={styles.nav}>
      <h3>MySchool</h3>
      <div>
        <Link to="/" style={styles.link}>Home</Link>
        <Link to="/events" style={styles.link}>Events</Link>
        <Link to="/blog" style={styles.link}>Blog</Link>
        <Link to="/contact" style={styles.link}>Contact</Link>
        <Link to="/login" style={styles.link}>Login</Link>
      </div>
    </nav>
  );
}

const styles = {
  nav: {
    display: "flex",
    justifyContent: "space-between",
    padding: "15px",
    background: "#1976d2",
    color: "#fff"
  },
  link: {
    margin: "0 10px",
    color: "#fff",
    textDecoration: "none"
  }
};

export default Header;