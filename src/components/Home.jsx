import React from "react";

function Home() {
  return (
    <div style={styles.page}>
      <h1>Welcome to MySchool</h1>
      <p>Your digital school management platform.</p>
    </div>
  );
}

const styles = {
  page: { padding: "20px" }
};

export default Home;