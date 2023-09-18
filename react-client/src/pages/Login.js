import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function Login() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    const handleLogin = () => {
        if (username === 'sena' && password === '123') {
            navigate('/hasta-component');
        } else {
            alert('Kullanıcı adı veya şifre hatalı.');
        }
    };

    return (
        <div>
            <h2>Login Sayfası</h2>
            <input
                type="text"
                placeholder="Kullanıcı Adı"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
            />
            <br />
            <input
                type="password"
                placeholder="Şifre"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
            />
            <br />
            <button onClick={handleLogin}>Giriş Yap</button>
        </div>
    );
}

export default Login;
