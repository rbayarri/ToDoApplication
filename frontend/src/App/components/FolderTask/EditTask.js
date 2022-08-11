import { useState, useEffect } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";

const EditTask = (props) => {
  const { idTask } = useParams();
  const [task, setTask] = useState([]);
  const [newDescription, setNewDescription] = useState("");
  const [idFolder, setIdeFolder] = useState("");
  let navigate = useNavigate();

  const getTask = async () => {
    const response = await fetch(`/tasks/${idTask}`);
    await !response.ok && navigate(`/error/task/${idTask}`);
    const body = await response.json();
    setTask(body);
    setNewDescription(body.description);
    setIdeFolder(body.folder.id);
  };

  useEffect(() => getTask(), []);

  const handleClickSave = async () => {
    await fetch(`/tasks/update/${idTask}/${newDescription}/${task.finished}`);
    navigate(`/folder/${idFolder}`);
  };

  return (
    <div className="container">
      <div className="col-12">
        <div className="my-5">
          <h1 className="mb-4">
            Editing Task "{task.description !== "" && task.description}"
          </h1>
          <div className="col-12 col-md-6 d-flex">
            <input
              type="text"
              className="col-8"
              value={newDescription}
              onChange={({ target: { value } }) => setNewDescription(value)}
            />
            <button
              className="btn btn-success btn-folder ms-2"
              onClick={handleClickSave}
            >
              Save
            </button>
            <Link
              to={idFolder !== "" && `/folder/${idFolder}`}
              className="btn btn-secondary btn-folder ms-2"
            >
              Cancel
            </Link>
          </div>
        </div>
      </div>
    </div>
  );
};

export default EditTask;
