import { Link, useParams } from "react-router-dom";

const ErrorPage = () => {

  const {element} = useParams();
  const {id} = useParams();

  return (
    <div className="container my-5">
      <h1 className="fs-4 p-3 mb-4 bg-danger text-white">Error: The {element} with id {id} was not found</h1>
      <Link to="/" className="btn btn-primary btn-folder">Back</Link>
    </div>
  );

}

export default ErrorPage;