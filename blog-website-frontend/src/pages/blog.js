import React, { useState, useEffect } from 'react';
import CommentForm from '../components/commentform'
import { useParams } from 'react-router-dom';
import '../styles/blog.css'

function Blog({ match }) {
  const [blog, setBlog] = useState(null);
  const [comments, setComments] = useState(null);
  const { id } = useParams();


  useEffect(() => {
    async function fetchBlog() {
      const response = await fetch(`http://localhost:8080/api/blog/${id}`);
      const json = await response.json();
      setBlog(json);
    }
    async function fetchComments() {
      const response = await fetch(`http://localhost:8080/api/blog/${id}/comments`);
      const json = await response.json();
      setComments(json);
    }

    fetchBlog();
    fetchComments();
  }, [id]);

  if (!blog) {
    return <div>Loading...</div>;
  }
  return (
    <div className='blog_wrapper'>
      <div className='blog'>
      <h1>{blog.title}</h1>
      <h3>author: {blog.author.first_name} {blog.author.last_name}</h3>
      <p>{blog.content}</p>
      </div>
      <h2>Comments:</h2>
      <div className='comment_wrapper'>
        <CommentForm blogId={blog.id} />
        {comments &&
        comments.map(comment => (
          <div key={comment.id} className='comments'>
            <p>{comment.author.first_name} {comment.author.last_name}:</p>
            <p>{comment.comment_text}</p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default Blog;