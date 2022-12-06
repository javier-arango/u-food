import React from "react";
import { useState } from "react";

// CSS
import "./Favorites.css";

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
    sectionName: "Favorites Restaurants",
    restaurants: restaurantsData,
  },
];

function Favorites() {
  const [sections, setSections] = useState(sectionsData);
  return (
    <>
      <div id="content">
        {sections.map((section) => {
          return <RestaurantSection section={section} scroll={"vertical"}/>;
        })}
      </div>
    </>
  );
}

export default Favorites;
