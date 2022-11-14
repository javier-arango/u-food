import React from "react";
import { Link } from "react-router-dom";

// Assets
import logo from "../../../assets/logo.png";
import checkmark from "../../../assets/checkmark.png";

function ResetPass(props) {
  /* 
        This component accepts the props type to know
        which type of confirmation that we are receiving.
        It will be an integer ranging from 0 to 1
        0 is for account creation confirmation
        1 is for password reset confirmation
    */
  const msg_confirm = [
    <p className="veri-msg">
      Your account has been successfully created. <br />
      An email was sent to your email address for verfication. <br />
      You can login after you verify your email.
    </p>,
    <p className="veri-msg">
      An email will be sent to the email you entered if <br />
      an account is associated with it. Please follow <br />
      the instructions in the email to set a new <br />
      password.
    </p>,
  ];

  return (
    <>
      <div className="container">
        <div id="banner"></div>
        <div className="sub-container">
          <img className="logo" src={logo} alt="UFood logo" />
          <img id="checkmark" src={checkmark} />
          {msg_confirm[props.type]}
          <button id="login-btn">Login</button>
        </div>
      </div>
    </>
  );
}

export default ResetPass;
