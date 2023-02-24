import React from 'react';
import './NavBar.css';


function Navbar() {
  return (
    <div className='NavBar'>
        <ul className="list">
            <li>
                <div className='home'>
                    <a>Home</a>
                </div>
            </li>
            <li>
                <div className='list_item'>
                    <a>Create Blog Post</a>
                </div>
            </li>
            <li>
                <div className='list_item'>
                    <a>My Blogs</a>
                </div>
            </li>
            <li>
                <div className='list_item'>
                    <a>Log In</a>
                </div>
            </li>
        </ul>
    </div>
  );
}

export default Navbar;