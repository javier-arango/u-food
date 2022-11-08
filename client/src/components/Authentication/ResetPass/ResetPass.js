import React, { useState } from "react";
import { Link } from "react-router-dom";

// Assets
import logo from "../../../assets/logo.png";

function ResetPass() {
  return (
    <>
      <div className="container">
        <div id="banner"></div>
        <div className="sub-container">
          <img className="logo" src={logo} alt="UFood logo" />

          <p class="veri-msg">Enter the email associated with your account</p>
          <input
            id="email-reset"
            type="email"
            name="email"
            placeholder="Email"
          />
          <button id="reset-btn">Reset Password</button>

          <Link to="/">Return back to login</Link>
        </div>
      </div>
    </>
  );
}

export default ResetPass;
