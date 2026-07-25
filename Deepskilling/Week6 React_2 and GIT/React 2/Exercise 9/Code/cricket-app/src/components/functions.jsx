export const functions = {
  OddPlayers: ([first, , third, , fifth]) => {
    return (
      <ul>
        <li>First: {first} </li>
        <li>Third: {third} </li>
        <li>Fifth: {fifth} </li>
      </ul>
    );
  },
  EvenPlayers: ([, second, , fourth, , sixth]) => {
    return (
      <ul>
        <li>Second: {second} </li>
        <li>fourth: {fourth} </li>
        <li>Sixth: {sixth} </li>
      </ul>
    );
  },
};
