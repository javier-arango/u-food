import React from "react";
import { useState } from "react";

// Components
import RestaurantSection from "../RestaurantSection/RestaurantSection";

// CSS File
import "./Home.css";

// Assets
import logo from "../../assets/logo.png";

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
      <div className="container">
        <nav id="mobile-nav">
          <img id="logo" src={logo} />
        </nav>

        <button id="search-btn">Search for Restaurants</button>

        <div id="content">
          {
            sections.map((section) => {
              return <RestaurantSection section={section} />;
            })
          }
        </div>
      </div>
    </>
  );
}

export default Home;
