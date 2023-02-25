import React, { useState, useEffect, useContext } from 'react';
import { UserContext } from '../userContext';
import { useNavigate } from "react-router-dom";

function CommentForm({ blogId }) {
  const {user} = useContext(UserContext)
  const navigate = useNavigate();

  const [comment, setComment] = useState('');

   const handleSubmit = async (event) => {
    event.preventDefault();

    let data = {
      "comment_text": comment,
      "post": blogId,
      "author": user.author_id,
  }
  
  console.log(data)
  await fetch('http://localhost:8080/api/blog/comment', {
      method: 'POST',
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify(data),
  })
      .then(response => response.json())
      .then(data => {
        if (data) {          
            window.location.reload();
        } else {
          console.log("Server returned empty response");
        }
          
      })
      .catch(error => {
          // Handle any errors here
          console.error(error);
});
  };

  return (
    <div className='create_comment'>{user ?  <form className='form_comment' onSubmit={handleSubmit}>
      <textarea className='textarea_comment' placeholder='Create Comment...' value={comment} onChange={(event) => setComment(event.target.value)} />
    <button type="submit">Submit</button>
  </form> : <div className='login_text'> Please Log in to comment</div>}</div>
  
  );
}

export default CommentForm;