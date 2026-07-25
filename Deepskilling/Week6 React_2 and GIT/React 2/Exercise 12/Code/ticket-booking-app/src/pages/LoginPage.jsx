import React from "react";

function LoginPage(props) {
  return (
    <div>
      Welcome to the Starting Page! Wanna Log in?<br></br>
      <button onClick={props.login}>Log In</button>
    </div>
  );
}

export default LoginPage;
