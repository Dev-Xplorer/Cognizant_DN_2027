const T20Players = ["First Player", "Second Player", "Third Player"];
const RanjiTrophyPlayers = ["Fourth Player", "Fifth Player", "Sixth Player"];

const PlayerList = [
  { name: "Sachin", score: 70 },
  { name: "Kholi", score: 80 },
  { name: "Dhoni", score: 10 },
  { name: "Jadeja", score: 60 },
  { name: "ABD", score: 100 },
  { name: "John Doe", score: 20 },
  { name: "Jane Doe", score: 40 },
];

export const PlayerData = {
  IndianPlayers: [...T20Players, ...RanjiTrophyPlayers],
  PlayerList: PlayerList,
};
