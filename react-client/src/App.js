import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Login from './pages/Login';
import HastaComponent from "./component/HastaComponent";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Login />} />
                <Route path="/hasta-component" element={<HastaComponent />} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;
