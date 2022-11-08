import React, { useState } from "react";
import { Route, Switch, Redirect } from "react-router-dom";
// CSS File
import "./App.css";

// Components
import Authentication from "../Authentication/Authentication";

function App() {
  const [loggedIn, setLoggedin] = useState(true);

  return (
    <Switch>
      <Route path="/" component={Authentication} />
    </Switch>
  );
}

export default App;
