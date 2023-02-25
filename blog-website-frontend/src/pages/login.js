import React, { useState,useEffect, useContext } from 'react';
import '../styles/login.css'
import { useUserUpdate, useUser, UserContext } from '../userContext';
import { useNavigate } from "react-router-dom";

function Login() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [loginError, setLoginError] = useState(false);
  const {user, setUser} = useContext(UserContext)
  const navigate = useNavigate();

  async function handleSubmit(event) {
    event.preventDefault();

    let data = {
        "username": username,
        "password": password
    }
    

    await fetch('http://localhost:8080/api/login', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(data),
    })
        .then(response => response.json())
        .then(data => {
            if(data.username == 'wrong'){
                setLoginError(true)
            }else{
                console.log(data)
                setUser(data)
                navigate("/");
            }
            
        })
        .catch(error => {
            // Handle any errors here
            console.error(error);
  });
  }
  useEffect(() => {
    console.log('this is the context:', user);
  }, [user]);
  

  return (
    <div className='login_wrapper'>
      <form onSubmit={handleSubmit}>
        <div className='login_flex'>
            <div className='box'>
                <h2>WELCOME TO THE LOGIN PAGE</h2>
            </div>
            <div className='box'>
                <label>
                Username:
                <input type="email" value={username} onChange={e => setUsername(e.target.value)} />
                </label>
            </div>
            <div className='box'>
                <label>
                Password:
                <input type="password" value={password} onChange={e => setPassword(e.target.value)} />
                </label>
            </div>
            <div className='box'>
                <button type="submit" onClick={handleSubmit}>Submit</button>
            </div>
            {loginError ? 'Wrong Username or Password' : ''}
            <div className='box-last'>
                <p>Dont have an account? <a href='/register'>Click here to create one!</a></p>
            </div>
        </div>
      </form>
    </div>
  );
}

export default Login;