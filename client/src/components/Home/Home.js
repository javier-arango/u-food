import React from "react";
import { useState } from "react";
import { Route, Routes } from "react-router-dom";

// Components
import HomeContent from "./HomeContent/HomeContent";
import Profile from "./Profile/Profile";
// CSS File
import "./Home.css";

// Assets
import logo from "../../assets/logo.png";
import bookmarksIcon from "../../assets/bookmark.svg";
import profileIcon from "../../assets/person.svg";

// template data
const restaurantsData = [
  {
    name: "I am",
    address: "5168 SW 34th Gainesville FL 32608",
    tag: "Latin",
    stars: 4.3,
    totalReviews: 324,
  },
  {
    name: "I am",
    address: "5168 SW 34th Gainesville FL 32608",
    tag: "Latin",
    stars: 4.3,
    totalReviews: 324,
  },
  {
    name: "I am",
    address: "5168 SW 34th Gainesville FL 32608",
    tag: "Latin",
    stars: 4.3,
    totalReviews: 324,
  },
];

const sectionsData = [
  {
    sectionName: "Restaurant Nearby",
    restaurants: restaurantsData,
  },
  {
    sectionName: "Latin",
    restaurants: restaurantsData,
  },
  {
    sectionName: "Vegan",
    restaurants: restaurantsData,
  },
];

function Home() {
  const [sections, setSections] = useState(sectionsData);
  return (
    <>
      <div className="home-container">
        <nav id="mobile-nav">
          <img id="logo" src={logo} />
          <div id="nav-items">
            <img src={bookmarksIcon} />
            <img src={profileIcon} />
          </div>
        </nav>

        <Routes>
          <Route path="/" element={<HomeContent />} />
          <Route path="/profile" element={<Profile />} />
        </Routes>
      </div>
    </>
  );
}

export default Home;
