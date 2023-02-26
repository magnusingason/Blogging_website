import '../styles/create_blog.css'
import React, { useState, useEffect, useContext } from 'react';
import { UserContext } from '../userContext';
import { useNavigate } from "react-router-dom";

function CreateBlog() {
  const {user} = useContext(UserContext)
  const [title, setTitle] = useState('');
  const [content, setContent] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (event) => {
    event.preventDefault();

    let data = {
        "title": title,
        "content": content,
        "author": user.author_id,
    }
    

    await fetch('http://localhost:8080/api/blog/post', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(data),
    })
        .then(response => response.json())
        .then(data => {
            
            
        })
        .catch(error => {
            // Handle any errors here
            console.error(error);
  });
  navigate("/");
  }

  return (
    <div className='createblog_wrapper'>
        <div className='createblog_flex'>
            <div className='blog_text'>
                Create your blog post here!
            </div>

            {user ? <form onSubmit={handleSubmit}>
                <div className='title'>
                    <label htmlFor="title">Title:</label>
                    <input
                        type="text"
                        id="title"
                        value={title}
                        onChange={(event) => setTitle(event.target.value)}
                    />  
                </div>
                <div className='content'>
                    <label htmlFor="content">Content:</label>
                    <textarea
                        id="content"
                        value={content}
                        onChange={(event) => setContent(event.target.value)}
                    />
                </div>
                <div className='submit'>
                    <button type="submit">Submit</button>
                </div>
            </form>  : <div> You need to be logged in to create a blog!</div>}

        </div>
    </div>
  );
}

export default CreateBlog;