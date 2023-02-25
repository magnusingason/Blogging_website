import '../styles/blogs.css';
import React, { useState, useEffect, useContext } from 'react';
import { UserContext } from '../userContext';
import { useNavigate } from 'react-router-dom'; 

function Blogs() {
  const [blogs, setBlogs] = useState([]);
  const {user} = useContext(UserContext)
  const navigate = useNavigate();

  const handleClick = (id) => {
    // Navigate to a new URL when the div is clicked
    navigate(`/blog/${id}`);
  }
  useEffect(() => {
    fetch('http://localhost:8080/api/blog/post')
      .then(response => response.json())
      .then(data => setBlogs(data))
      .catch(error => console.error(error));
  }, []);

  useEffect(() => {
  }, [JSON.stringify(user)]);

  return (
    <div>
        <h1 className='title_thing'>{user ?  `Hello ${user.first_name}` : 'Welcome to this Blog Website'}</h1>
    <div className="blogs_wrapper">
        
            {blogs.map(blog => (
                <div className="blog_in_list"  key={blog.id} onClick={() => handleClick(blog.id)}>
                  <div className="title_author_container">
                    <a className="blog_title">{blog.title}</a>
                    <a className='blog_author'>Written by: {blog.author.first_name} {blog.author.last_name}</a>
                  </div>
                    <div className='blog_content_container'>
                      <p className='blog_content'>{blog.content}</p>
                    </div>
                </div>
            ))}
        
    </div>
    </div>
  );
}

export default Blogs;
