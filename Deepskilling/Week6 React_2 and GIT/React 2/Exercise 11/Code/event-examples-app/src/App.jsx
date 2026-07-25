import { useState } from "react";

function App() {
  const [count, setCount] = useState(1);
  const [currency, setCurrency] = useState("");
  const [amount, setAmount] = useState(0);

  const convert = () => {
    if (currency == "Dollar") alert("The Converted Rupees is: " + amount * 80);
    else if (currency == "Euro")
      alert("The Converted Rupees is: " + amount * 100);
  };

  return (
    <>
      <button
        onClick={() => {
          setCount((value) => ++value);
          alert("Hello Member " + count);
        }}
      >
        Increment
      </button>
      <br></br>
      <button onClick={() => setCount((value) => value - 1)}>Decrement</button>
      <br></br>
      <button onClick={() => alert("Welcome")}>Say Welcome</button>
      <br></br>
      <button onClick={() => alert("I was clciked")}>Click Me</button>
      <br></br>
      <hr></hr>
      <h1 style={{ color: "green", fontWeight: "bold" }}>Currency Convertor</h1>
      <label>Amount: </label>
      <input
        type="number"
        onChange={(e) => {
          setAmount(e.target.value);
        }}
      ></input>
      <br></br>
      <label>Currency: </label>
      <input
        type="text"
        onChange={(e) => {
          setCurrency(e.target.value);
        }}
      ></input>
      <br></br>
      <button onClick={convert}>Submit</button>
    </>
  );
}

export default App;
