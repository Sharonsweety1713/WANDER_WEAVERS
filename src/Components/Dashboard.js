import { Link } from 'react-router-dom'
import React from 'react';
const Dashboard=()=>{
   
    return(
      <>
      
      <div className='db'>
      <div className="wel">
        <h1 className="welcome-message">Hello, It's Here where your journey begins!</h1>
        <img
          src='https://img.freepik.com/premium-vector/meeting-business-people-avatar-character_24877-58529.jpg?w=360'
          alt="Welcome"
          className="wel-img"
        />
      </div>
    </div>
      <ul class="sidebar">
     <Link to="/Profile">
      <li class="sidebar-brand"><span>Create Profile</span></li>
      </Link>
      <Link to="/Explore">
      <li><span>Explore</span></li>
      </Link>
      <Link to="/Jobs">
      <li><span>Find Jobs</span></li>
      </Link>
      <div className='out'>
      <Link to="/Homepage">
      <li>Logout</li>
      </Link>
      </div>
      </ul> 
      </>

    )
}
export default Dashboard

