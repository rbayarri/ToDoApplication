package com.todolist.ToDoList.services;

import com.todolist.ToDoList.entities.Folder;
import com.todolist.ToDoList.exceptions.ErrorService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.todolist.ToDoList.repositories.FolderRepository;
import static com.todolist.ToDoList.validations.Validations.validateString;

@Service
public class FolderService {

  @Autowired
  private FolderRepository folderRepository;

  @Transactional
  public Folder createFolder(String name) throws ErrorService {
    validateString(name);
    Folder folder = new Folder();
    folder.setName(name);
    return folderRepository.save(folder);
  }

  @Transactional
  public Folder updateName(Integer id, String name) throws ErrorService {
    validateString(name);
    Optional<Folder> response = folderRepository.findById(id);
    if (response.isPresent()) {
      Folder folder = response.get();
      folder.setName(name);
      return folderRepository.save(folder);
    }
    throw new ErrorService("The folder id was not found");
  }

  @Transactional
  public void removeFolder(Integer id) throws ErrorService {
    Optional<Folder> response = folderRepository.findById(id);
    if (response.isPresent()) {
      Folder folder = response.get();
      folderRepository.delete(folder);
    } else {
      throw new ErrorService("The folder id was not found");
    }
  }
  
  @Transactional(readOnly = true)
  public Folder findById(Integer id) throws ErrorService{
    Optional<Folder> response = folderRepository.findById(id);
    if(response.isPresent()){
      return response.get();
    }
    throw new ErrorService("The folder id was not found");
  }
  
  @Transactional(readOnly = true)
  public List<Folder> listFolders(){
    return folderRepository.findAll();
  }

}
