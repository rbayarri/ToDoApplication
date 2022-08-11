import React, { useState } from "react";
import { useEffect } from "react/cjs/react.development";
import { Link } from "react-router-dom";

const Task = (props) => {
  const [checked, setChecked] = useState(props.task.finished);

  const handleChangeCheckbox = () => {
    setChecked(!checked);
  };

  useEffect(() => {
    props.task.finished !== checked && updateFinished();
  }, [checked]);

  async function updateFinished () {
    await fetch((`/tasks/update/${props.task.id}/${props.task.description}/${checked}`))
  };

  return (
    <div className="col-lg-8 my-2">
      <div className="row align-items-center mb-2">
        <input
          type="checkbox"
          className="col-1"
          checked={checked}
          onChange={handleChangeCheckbox}
        />
        <p className="col my-0">{props.task.description}</p>
        <div className="col ms-2 mt-2">
          <Link to={`/task/${props.task.id}`} className="btn btn-primary btn-folder">Edit</Link>
        </div>
      </div>
    </div>
  );
};

export default Task;