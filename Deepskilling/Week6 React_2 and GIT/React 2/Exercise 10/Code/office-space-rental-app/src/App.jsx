import Item from "./assets/Components/Item";

function App() {
  const items = [
    {
      imgSrc:
        "https://cdn.sanity.io/images/uqxwe2qj/production/62db3c671745e98cb27690dff96f8033d2bb7f35-2048x1010.jpg",
      name: "XYZ",
      rent: 50000,
      address: "Chennai",
    },
  ];
  return (
    <>
      <h1>Office Space</h1>
      {items.map((item) => (
        <Item key={item.name} item={item} />
      ))}
    </>
  );
}

export default App;
