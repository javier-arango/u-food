import React, { useState } from "react";
import { Route, Routes } from "react-router-dom";
// CSS File
import "./Authentication.css";

// Components
import Login from "./Login/Login";
import ResetPass from "./ResetPass/ResetPass";
import RegistrationConfirm from "./RegistrationConfirm/RegistrationConfirm";

function Authentication() {
  const [loggedIn, setLoggedin] = useState(false);

  return (
    <>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/resetPassword" element={<ResetPass/>} />
      </Routes>
    </>
  );
}

export default Authentication;
