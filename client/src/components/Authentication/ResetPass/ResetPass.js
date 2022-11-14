import React, { useState } from "react";
import { Link } from "react-router-dom";

// Assets
import logo from "../../../assets/logo.png";

function ResetPass() {
  const [email, setEmail] = useState("");

  // Handle when the input of the email is changed
  const handleChange = (e) => {
    setEmail(e.target.value);
  };

  // Handle when the user click the reset password button
  const handleSubmit = () => {
    console.log(email);
  };

  return (
    <>
      <div className="container">
        <div id="banner"></div>
        <div className="sub-container">
          <img className="logo" src={logo} alt="UFood logo" />

          <p className="veri-msg">Enter the email associated with your account</p>
          <input
            id="email-reset"
            type="email"
            name="email"
            placeholder="Email"
            onChange={handleChange}
          />
          <button type="submit" id="reset-btn" onClick={handleSubmit}>Reset Password</button>
          <br/>
          <Link to="/">Return back to login</Link>
        </div>
      </div>
    </>
  );
}

export default ResetPass;
