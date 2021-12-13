import React from "react";
import ReactDOM from "react-dom";
import App from "./App/";
import FolderTasks from "./App/components/FolderTask";
import EditTask from "./App/components/FolderTask/EditTask";
import ErrorPage from "./App/components/ErrorPage/ErrorPage";
import './index.css'
import reportWebVitals from "./reportWebVitals";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter } from "react-router-dom";
import {Route, Routes} from 'react-router-dom'

ReactDOM.render(
  <BrowserRouter>
    <Routes>
      <Route exact path="/" element={<App />}/>
      <Route path="/folder/:idFolder" element={<FolderTasks/>}/>
      <Route path="/task/:idTask" element={<EditTask />}/>
      <Route path="/error/:element/:id" element={<ErrorPage />}/>
    </Routes>
  </BrowserRouter>,
  document.getElementById("root")
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
