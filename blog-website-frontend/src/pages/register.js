import React, { useState,useEffect, useContext } from 'react';
import '../styles/login.css'
import { useUserUpdate, useUser, UserContext } from '../userContext';
import { useNavigate } from "react-router-dom";

function Register() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [first_name, setFirst_name] = useState('')
  const [last_name, setLast_name] = useState('')
  const [bio, setBio] = useState('')
  const [registerError, setRegisterError] = useState(false);
  const {user, setUser} = useContext(UserContext)
  const navigate = useNavigate();

  async function handleSubmit(event) {
    event.preventDefault();

    let data = {
        "username": username,
        "password": password,
        "first_name": first_name,
        "last_name": last_name,
        "bio": bio
    }
    console.log(data)

    await fetch('http://localhost:8080/api/signup', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(data),
    })
        .then(response => response.json())
        .then(data => {
            if(data === 'something went wrong with creating an author'){
                setRegisterError(true)
            }else{
                alert("Registration successful!")
                setUser(data)
                navigate("/");
            }
            
        })
        .catch(error => {
            setRegisterError(true)
            console.error(error);
  });
  }
  

  return (
    <div className='login_wrapper'>
      <form onSubmit={handleSubmit}>
        <div className='login_flex'>
            <div className='box'>
                <h2>WELCOME TO THE REGISTER PAGE</h2>
            </div>
            <div className='box'>
                <label>
                Create Username:
                <input type="email" value={username} onChange={e => setUsername(e.target.value)} />
                </label>
            </div>
            <div className='box'>
                <label>
                Create Password:
                <input type="password" value={password} onChange={e => setPassword(e.target.value)} />
                </label>
            </div>
            <div className='namelogin'>
                <div className='name'>
                    <label>
                    Your First Name:
                    <input type="email" value={first_name} onChange={e => setFirst_name(e.target.value)} />
                    </label>
                </div>
                <div className='name'>
                    <label>
                    Your Last Name:
                    <input type="text" value={last_name} onChange={e => setLast_name(e.target.value)} />
                    </label>
                </div>
            </div>
            <div className='box'>
                <label>
                    Your Bio:
                <input type="textbox" value={bio} onChange={e => setBio(e.target.value)} />
                </label>
            </div>
            <div className='box'>
                <button type="submit" onClick={handleSubmit}>Submit</button>
            </div>
            {registerError ? 'Something went wrong, please try again' : ''}
        </div>
      </form>
    </div>
  );
}

export default Register;