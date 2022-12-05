import React from "react";
import { useState } from "react";
import { Route, Routes, Link } from "react-router-dom";

// Components
import HomeContent from "./HomeContent/HomeContent";
import Profile from "./Profile/Profile";

// CSS File
import "./Home.css";

// Assets
import logo from "../../assets/logo.png";
import bookmarksIcon from "../../assets/bookmark.svg";
import profileIcon from "../../assets/person.svg";
import Favorites from "./Favorites/Favorites";

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
          <Link to={`/home`}>
            <img id="logo" src={logo} />
          </Link>
          <div id="nav-items">
            <Link to={`favorites`}>
              <img src={bookmarksIcon} />
            </Link>
            <Link to={`profile`}>
              <img src={profileIcon} />
            </Link>
          </div>
        </nav>
        <Routes>
          <Route path="/" element={<HomeContent />} />
          <Route path="/profile" element={<Profile />} />
          <Route path="/favorites" element={<Favorites />} />
        </Routes>
      </div>
    </>
  );
}

export default Home;
