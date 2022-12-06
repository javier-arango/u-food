import React, { useState } from "react";

// Assets
import logo from "../../../assets/logo.png";
import bannerImage from "../../../assets/login_banner.png";

//Functions
import {verifyPassword} from "../../../utils/utils";
import * as api from "../../../api/index"

// Initital State for the form Data
const initialState = {
  firstName: "",
  lastName: "",
  email: "",
  password: "",
  verifyPassword: "",
};

function Login() {
  const [isSignup, setIsSignup] = useState(true);
  const [formData, setFormData] = useState(initialState);

  //gets data for signup
  const signUpFunc = async (formData) => {
    const {data} = await api.signup(formData)
    return data
  }

  //data for login
  const loginFunc = async (formData) => {
    const {data} = await api.login(formData)
    return data
  }
  // Handle the submit of the form when login or signup
  const handleSubmit = (e) => {
    e.preventDefault();

    // TODO: Debugging
    console.log(formData);

    if (isSignup) {
      // Call Signup function if passwords match
      if (verifyPassword(formData.password, formData.verifyPassword)) {
        signUpFunc(formData).then((response) => {})
      }
    } else {
      // Call login function
      loginFunc(formData).then((response) => {})
    }
  }
  ;


  // Handle when a value in the form has been changed
  const handleChange = (e) => {

    setFormData({...formData, [e.target.name]: e.target.value});
  };

  // Handle the switch between the login and sign up form
  const switchMode = () => {
    setIsSignup((prevIsSignup) => !prevIsSignup);
  };

  return (
      <>
        <div className="container">
          <div
              id="banner"
              style={{backgroundImage: `url(${bannerImage})`}}
          ></div>
          <div className="sub-container">
            <h1 id="login-slogan">
              Discover <br/>
              your restaurant of choice <br/>
              with
            </h1>
            <img className="logo" src={logo} alt="UFood logo"/>
            <form id="auth-form" onSubmit={handleSubmit}>
              {isSignup && (
                  <>
                    <input
                        type="text"
                        name="firstName"
                        placeholder="First Name"
                        onChange={handleChange}
                    />
                    <input
                        type="text"
                        name="lastName"
                        placeholder="Last Name"
                        onChange={handleChange}
                    />
                  </>
              )}
              <input type="email" name="email" placeholder="Email"/>
              <input
                  type="password"
                  name="password"
                  placeholder="Password"
                  onChange={handleChange}
              />
              <input
                  type="password"
                  name="verifyPassword"
                  placeholder="Enter Password again"
                  onChange={handleChange}
              />
              <input
                  type="submit"
                  name="submit"
                  value={isSignup ? "Sign Up" : "Login"}
                  onChange={handleChange}
              />
            </form>

            {!isSignup && (
                <>
                  <a id="fg-pass" href="/resetPassword">
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

export default Login;
