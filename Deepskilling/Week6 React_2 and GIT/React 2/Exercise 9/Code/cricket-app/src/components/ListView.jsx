import React from "react";

function ListView({ PlayerNames }) {
  return (
    <div>
      <ul>
        {PlayerNames.map((value, index) => {
          return (
            <li key={value + index}>
              {value.name}, {value.score}
            </li>
          );
        })}
      </ul>
    </div>
  );
}

export default ListView;
