import React from "react";

// CSS File
import "./Home.css";

// Assets
import logo from "../../assets/logo.png";
import noImage from "../../assets/no_image.png";
import favoriteIcon from "../../assets/favorite.svg";

function Home() {
  return (
    <>
      <div className="container">
        <nav id="mobile-nav">
          <img id="logo" src={logo} />
        </nav>

        <button id="search-btn">Search for Restaurants</button>

        <div id="content">
          <section className="restaurant-section">
            <h3 className="title">Restaurants Nearby</h3>

            <div className="restaurants-ctn">
              <div className="restaurants">
                <div className="restaurant">
                  <div
                    className="img-ctn"
                    style={{ backgroundImage: `url(${noImage})` }}
                  >
                    <div className="icon-ctn">
                      <img src={favoriteIcon} className="favorite-icon" />
                    </div>
                  </div>
                  <h4 className="rst-name">Restaurant Name</h4>
                  <div className="info">
                    <p className="address">5168 SW 34th Gainesville FL 32608</p>
                    <div className="review-info">
                      <div className="tag">Latin</div>
                      <p className="stars">4.3 stars</p>
                      <p className="reviews-ctn">324 reviews</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>
        </div>
      </div>
    </>
  );
}

export default Home;
