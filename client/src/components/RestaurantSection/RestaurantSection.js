import React from "react";
import { useState } from "react";
// Components
import Restaurant from "../Restaurant/Restaurant";

function RestaurantSection(props) {
  const section = props.section;
  return (
    <>
      <section className="restaurant-section">
        <h3 className="title">{section.sectionName}</h3>

        <div
          className={
            props.scroll == "horizontal"
              ? "restaurants-ctn-horizontal"
              : "restaurants-ctn-vertical"
          }
        >
          <div
            className={
              props.scroll == "horizontal"
                ? "restaurants-horizontal"
                : "restaurants-vertical"
            }
          >
            {section.restaurants.map((restaurant) => {
              return <Restaurant restaurant={restaurant} />;
            })}
          </div>
        </div>
      </section>
    </>
  );
}

export default RestaurantSection;
