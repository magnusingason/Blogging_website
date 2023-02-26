
import './App.css';
import React, {useState, useMemo, useEffect} from 'react';
import Blogs from './pages/blogs'
import Blog from './pages/blog'
import Navbar from './components/navbar'
import ProfilePage from './pages/profile'
import Login from './pages/login'
import CreateBlog from './pages/create_blog'
import Register from './pages/register'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { UserContext } from './userContext';

function App() {

  const [user, setUser] = useState(() => {
    // Initialize user state from local storage if it exists
    const storedUser = localStorage.getItem('user');
    return storedUser ? JSON.parse(storedUser) : null;
  });

  // Save the user to local storage whenever it changes
  useEffect(() => {
    localStorage.setItem('user', JSON.stringify(user));
  }, [user]);

  const value = useMemo (() => ({user, setUser}), [user,setUser]);

  return (
    <>
      <Router>
        <UserContext.Provider value={value}>
          <Navbar />
          <Routes>
              <Route exact path="/" element={<Blogs />} />
              <Route exact path="/register" element={<Register />} />
              <Route exact path="/login" element={<Login />} />
              <Route path="/blog/:id" element={<Blog />} />
              <Route path="/profile/:id" element={<ProfilePage />} />
              <Route path="/blog/create" element={<CreateBlog />} />
          </Routes>
        </UserContext.Provider>
      </Router>
</>
  );
}

export default App;
