import React from "react";
import { useState } from "react";

// template data
const profileData = {};

function Profile() {
  const [profile, setProfile] = useState(profileData);
  return (
    <>
      <div class="profile-container">
        <h1>Profile Information</h1>
        <div id="profile-info">
          <div>
            <h2>First Name</h2>
            <h3>Michael</h3>
          </div>
          <div>
            <h2>Last Name</h2>
            <h3>Jordan</h3>
          </div>
          <div>
            <h2>Email</h2>
            <h3>mjbasketball@gmail.com</h3>
          </div>
          <div>
            <h2>Password</h2>
            <a href="https://www.w3schools.com/">change password</a>
          </div>
        </div>

        <div id="profile-actions">
          <button id="prof-edit-btn">Edit Profile</button>
          <button id="prof-delete-btn">Delete Account</button>
        </div>
      </div>
    </>
  );
}

export default Profile;
