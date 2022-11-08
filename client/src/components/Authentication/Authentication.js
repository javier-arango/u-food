import React, { useState } from "react";
import { Redirect, Route, Switch } from "react-router-dom";
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
      <Switch>
        <Route path="/login" component={Login} />
        <Route path="/resetPassword" component={ResetPass} />
        <Route path="/confirmation" component={RegistrationConfirm} />
      </Switch>
    </>
  );
}

export default Authentication;
