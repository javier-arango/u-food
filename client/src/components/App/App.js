import React from "react";
import { Route, Routes } from "react-router-dom";
// CSS File
import "./App.css";

// Components
import Authentication from "../Authentication/Authentication";
import Home from "../Home/Home";

function App() {
  return (
    <>
      <Routes>
        <Route path="*" element={<Authentication />} />
        <Route path="/home" element={<Home />} />
      </Routes>
    </>
  );
}

export default App;
