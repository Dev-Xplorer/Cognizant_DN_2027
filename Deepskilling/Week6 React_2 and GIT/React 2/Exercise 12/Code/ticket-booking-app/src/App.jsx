import { useState } from "react";
import HomePage from "./pages/HomePage";
import LoginPage from "./pages/LoginPage";

function App() {
  const [isLoggedIn, setLogin] = useState(false);

  const login = () => {
    setLogin((value) => !value);
  };

  return (
    <>{isLoggedIn ? <HomePage login={login} /> : <LoginPage login={login} />}</>
  );
}

export default App;
