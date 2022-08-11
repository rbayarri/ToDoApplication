import React, { useState } from "react";

const New = (props) => {
  const [newName, setNewName] = useState("");

  async function handleClickButtonFolder() {
    await fetch(`/folders/create/${newName}`);
    await props.action();
    setNewName("");
  }

  async function handleClickButtonTask() {
    await fetch(`/tasks/create/${newName}/${props.folder}`);
    await props.action();
    setNewName("");
    //ruta a FolderTasks
  }

  return (
    <div className="col-lg-6 col-12 mb-5">
      <p className="fw-bold text-decoration-underline fs-5">
        Create {props.type}
      </p>
      <div className="row d-block">
        <div className="d-flex">
          <input
            type="text"
            className="col-8 me-3"
            placeholder={"New " + props.type + " Name"}
            value={newName}
            onChange={({ target: { value } }) => setNewName(value)}
          />
          <button
            className="btn btn-sm btn-success btn-folder"
            disabled={newName===""}
            onClick={
              props.type === "Folder"
                ? handleClickButtonFolder
                : handleClickButtonTask
            }
          >
            Add
          </button>
        </div>
      </div>
    </div>
  );
};

export default New;
