import React, { useState, useEffect } from "react";
import Task from "./Task";
import New from "../New";
import { Link, useNavigate, useParams } from "react-router-dom";

const FolderTasks = (props) => {

  let navigate = useNavigate();

  const { idFolder } = useParams();
  const [tasks, setTasks] = useState([]);
  const [nameFolder, setNameFolder] = useState("");

  const getFolderName = async () => {
    const response = await fetch(`/folders/${idFolder}`);
    const body = await response.json();
    setNameFolder(body.name);
  };

  const getFolderTasks = async () => {
    const response = await fetch("/folders/" + idFolder + "/tasks");
    await !response.ok && navigate(`/error/folder/${idFolder}`);
    const body = await response.json();
    setTasks(body);
  };

  useEffect(() => {
    getFolderName().catch(null);
    getFolderTasks().catch(null);
  }, []);

  const renderTasks = () => {
    return (
      <div>
        {tasks.map((task) => (
          <Task key={task.id} task={task} />
        ))}
      </div>
    );
  };
  return (
    <div className="container">
      <div className="col-12">
        <div className="my-5">
          <h1 className="mb-4">
            <Link to="/">Folder</Link> {">"}{" "}
            {nameFolder !== "" &&
              nameFolder[0].toUpperCase() + nameFolder.slice(1)}
          </h1>
          {renderTasks()}
        </div>
        <New type="Task" folder={idFolder} action={getFolderTasks} />
      </div>
    </div>
  );
};

export default FolderTasks;
