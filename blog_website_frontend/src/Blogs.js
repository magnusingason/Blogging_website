import './Blogs.css';
import React, { useState, useEffect } from 'react';

function Blogs() {
  const [blogs, setBlogs] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/api/blog/post')
      .then(response => response.json())
      .then(data => setBlogs(data))
      .catch(error => console.error(error));
  }, []);

  return (
    <div className="blogs_wrapper">
        <h1>Blogs:</h1>
            {blogs.map(blog => (
                <div className="blog_in_list"  key={blog.id}>
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
  );
}

export default Blogs;
