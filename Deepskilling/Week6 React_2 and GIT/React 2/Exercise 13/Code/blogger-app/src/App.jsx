import "./App.css";

function App() {
  const courseDetails = (
    <>
      <h2>Angular</h2>
      <p>04/05/2021</p>
      <h2>React</h2>
      <p>06/03/2021</p>
    </>
  );
  const bookDetails = (
    <>
      <h5>Master React</h5>
      <p>670</p>
      <h5>Deep Dive into Angular</h5>
      <p>800</p>
    </>
  );
  const blogDetails = (
    <>
      <h1>React Learning</h1>
      <h5>Stephen Biz</h5>
      <p>Welcome to learning</p>
      <h1>Installation</h1>
      <h5>Schewzdenier</h5>
      <p>You can Install React from npm</p>
    </>
  );

  return (
    <div className="container">
      <div className="box box-right">
        <h1>Course Details</h1>
        {courseDetails}
      </div>
      <div className="box">
        <h1>Book Details</h1>
        {bookDetails}
      </div>
      <div className="box box-left">
        <h1>Blog Details</h1>
        {blogDetails}
      </div>
    </div>
  );
}

export default App;
