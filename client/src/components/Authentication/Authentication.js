import React, { useState } from "react";
// CSS File
import "./Authentication.css";

// Assets
import logo from "../../assets/logo.png";

function Authentication() {
  const [isSignup, setIsSignup] = useState(true);

  // Helper Functions
  const switchMode = () => {
    setIsSignup((prevIsSignup) => !prevIsSignup);
  };
  return (
    <>
      <div className="container">
        <div id="banner"></div>
        <div className="sub-container">
          <h1 id="login-slogan">
            Discover <br />
            your restaurant of choice <br />
            with
          </h1>
          <img className="logo" src={logo} alt="UFood logo" />
          <form id="auth-form">
            {isSignup && (
              <>
                <input type="text" name="fname" placeholder="First Name" />
                <input type="text" name="lname" placeholder="Last Name" />
              </>
            )}
            <input type="email" name="email" placeholder="Email" />
            <input type="password" name="password" placeholder="Password" />
            <input
              type="submit"
              name="submit"
              value={isSignup ? "Sign Up" : "Login"}
            />
          </form>

          {!isSignup && (
            <>
              <a id="fg-pass" href="#">
                Forgot password?
              </a>
            </>
          )}

          <p id="no-account">
            {isSignup ? "Have an account already" : "Don't have an account"}?{" "}
            <a href="#" onClick={switchMode}>
              {isSignup ? "Login" : "Sign up"}
            </a>
          </p>
        </div>
      </div>
    </>
  );
}

export default Authentication;
