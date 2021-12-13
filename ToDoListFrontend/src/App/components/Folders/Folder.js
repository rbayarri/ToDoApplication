import React from "react";
import { Link } from "react-router-dom";

const Folder = (props) => {
  async function handleClickRemoveFolder() {
    await fetch(`/folders/delete/${props.folder.id}`);
    await props.action();
  }

  return (
    <div className="col-lg-6 my-2">
      <div className="row d-flex justify-content-between">
        <ul className="col">
          <li>
            {props.folder.name[0].toUpperCase() + props.folder.name.slice(1)}
          </li>
        </ul>
        <div className="col mb-2">
          <Link to={`/folder/${props.folder.id}`} className="btn btn-primary btn-folder">View Items</Link>
          <button
            className="ms-3 btn btn-danger btn-folder"
            onClick={handleClickRemoveFolder}
          >
            Remove
          </button>
        </div>
      </div>
    </div>
  );
};

export default Folder;
