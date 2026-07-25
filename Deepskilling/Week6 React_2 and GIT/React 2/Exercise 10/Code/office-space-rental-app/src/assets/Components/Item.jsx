import React from "react";

function Item({ item }) {
  console.log(item);
  return (
    <div>
      <img src={item.imgSrc} style={{ maxWidth: 200, maxHeight: 200 }}></img>
      <h2>Name : {item.name}</h2>
      <div style={{ color: item.rent <= 6000 ? "red" : "green" }}>
        Rent: Rs. {item.rent}
      </div>
      <div>Address: {item.address}</div>
    </div>
  );
}

export default Item;
