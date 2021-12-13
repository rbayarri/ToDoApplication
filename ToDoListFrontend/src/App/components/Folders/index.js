import React, { useState, useEffect } from "react";
import Folder from "./Folder";
import New from "../New";

const Folders = () => {
  const [folders, setFolders] = useState([]);

  const getFolders = async () => {
    const response = await fetch("/folders");
    const body = await response.json();
    setFolders(body);
  };

  useEffect(() => {
    getFolders().catch(null);
  }, []);

  const renderFolders = () =>
    folders.map((folder) => <Folder key={folder.id} folder={folder} action={getFolders} />);

  return (
    <React.Fragment>
      <div className="my-5">
        <h1 className="mb-4">Folders</h1>
        {renderFolders()}
      </div>
      <New type="Folder" action={getFolders} />
    </React.Fragment>
  );
};

export default Folders;
