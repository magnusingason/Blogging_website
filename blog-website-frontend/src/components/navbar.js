import React, {useContext } from 'react';
import '../styles/navbar.css';
import { UserContext } from '../userContext';


function Navbar() {
    const {user, setUser} = useContext(UserContext)


  return (
    <div className='NavBar'>
                <div className='home'>
                    <a href='/'>Home</a>
                </div>
                <div className='list_item' > 
                    <a href='/blog/create'>Create Blog Post</a>
                </div>
                <div className='list_item'>
                    {user ? <a href={`/profile/${user.author_id}`}>My Blogs</a> : <a  href='/login'>My Blogs</a>}
                </div>
                <div className='list_item'>
                    {user ? <a onClick={ () => setUser(null)} > Log Out</a> : <a href='/login'>Log In</a>}
                </div>
        </div>
  );
}

export default Navbar;