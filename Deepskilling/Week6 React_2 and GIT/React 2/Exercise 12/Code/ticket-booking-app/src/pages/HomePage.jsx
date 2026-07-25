import React from "react";

function HomePage(props) {
  return (
    <div>
      Welcome To the HomePage!<br></br>
      <button onClick={props.login}>Log Out</button>
    </div>
  );
}

export default HomePage;
