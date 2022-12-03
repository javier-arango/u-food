import React from "react";

// Assets
import noImage from "../../assets/no_image.png";
import favoriteIcon from "../../assets/favorite.svg";
import removeIcon from "../../assets/remove.svg";

function Restaurant(props) {
  const restaurant = props.restaurant;
  return (
    <>
      <div className="restaurant">
        <div className="img-ctn" style={{ backgroundImage: `url(${noImage})` }}>
          <div className="icon-ctn">
            <img src={favoriteIcon} className="favorite-icon" />
          </div>
        </div>
        <h4 className="rst-name">{restaurant.name}</h4>
        <div className="info">
          <p className="address">{restaurant.address}</p>
          <div className="review-info">
            <div className="tag">{restaurant.tag}</div>
            <p className="stars">{restaurant.stars} stars</p>
            <p className="reviews-ctn">{restaurant.totalReviews} reviews</p>
          </div>
        </div>
      </div>
    </>
  );
}

export default Restaurant;
