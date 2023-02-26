import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { useNavigate } from 'react-router-dom'; 
import '../styles/profile.css'

function ProfilePage() {
  const { id } = useParams();
  const [profile, setProfile] = useState(null);
  const [blogs, setBlogs] = useState(null);
  const navigate = useNavigate();

  const handleClick = (id) => {
    // Navigate to a new URL when the div is clicked
    navigate(`/blog/${id}`);
  }

  useEffect(() => {
    fetch(`http://localhost:8080/api/profile/${id}`)
      .then(response => response.json())
      .then(data => setProfile(data));
      fetch(`http://localhost:8080/api/blog/user/${id}`)
      .then(response => response.json())
      .then(data => setBlogs(data));
  }, [id]);

  return (
    <div>
        <div className='profile_upper'>
      <h1>Profile Page</h1>
      {profile && (
        <>
          <h2>{profile.first_name} {profile.last_name}</h2>
          <p>{profile.bio}</p>
        </>
      )}
      </div>
        <div className="blogs_wrapper">
            {blogs && blogs.map(blog => (
                <div className="blog_in_list" key={blog.id} onClick={() => handleClick(blog.id)}>
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

export default ProfilePage;