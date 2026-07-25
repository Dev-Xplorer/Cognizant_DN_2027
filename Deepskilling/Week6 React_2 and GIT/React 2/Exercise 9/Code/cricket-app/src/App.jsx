import "./App.css";

import { PlayerData } from "./components/Details";
import ListView from "./components/ListView";
import { functions } from "./components/functions";

function App() {
  let flag = 1;
  return (
    <>
      {flag == 1 ? (
        <div>
          <h1>List of Players</h1>
          <ListView PlayerNames={PlayerData.PlayerList} />{" "}
          <h1>List of Players Who have less than 70 scores</h1>
          <ListView
            PlayerNames={PlayerData.PlayerList.filter((val) => val.score < 70)}
          />
        </div>
      ) : (
        <div>
          <h1>List of Odd Players</h1>
          {functions.OddPlayers(PlayerData.IndianPlayers)}
          <h1>List of Even Players</h1>
          {functions.EvenPlayers(PlayerData.IndianPlayers)}
          <h1>List of Merged Players</h1>
          <ul>
            {PlayerData.IndianPlayers.map((value, index) => (
              <li key={value + index}>{value}</li>
            ))}
          </ul>
        </div>
      )}
    </>
  );
}

export default App;
