import React from "react";
import { useState } from "react";

// Components
import RestaurantSection from "../../RestaurantSection/RestaurantSection";

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

function HomeContent() {
  const [sections, setSections] = useState(sectionsData);
  return (
    <>
        <button id="search-btn">Search for Restaurants</button>

        <div id="content">
          {sections.map((section) => {
            return <RestaurantSection section={section} scroll="horizontal"/>;
          })}
        </div>
    </>
  );
}

export default HomeContent;
