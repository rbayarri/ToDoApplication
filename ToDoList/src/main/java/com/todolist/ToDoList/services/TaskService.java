package com.todolist.ToDoList.services;

import com.todolist.ToDoList.entities.Folder;
import com.todolist.ToDoList.entities.Task;
import com.todolist.ToDoList.exceptions.ErrorService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.todolist.ToDoList.repositories.TaskRepository;
import static com.todolist.ToDoList.validations.Validations.validateString;

@Service
public class TaskService {
  
  @Autowired
  private TaskRepository taskRepository;
  
  @Autowired
  private FolderService folderService;
  
  @Transactional
  public Task createTask(String description, Integer idFolder) throws ErrorService{
    
    validateString(description);
    Folder folder = folderService.findById(idFolder);
    Task task = new Task();
    task.setDescription(description);
    task.setFolder(folder);
    return taskRepository.save(task);
  
  }
  
  @Transactional
  public Task updateDescription(Integer id, String description) throws ErrorService{
    validateString(description);
    Optional<Task> response = taskRepository.findById(id);
    if(response.isPresent()){
      Task task = response.get();
      task.setDescription(description);
      return taskRepository.save(task);
    }
    throw new ErrorService("The task id was not found");
  }
  
  @Transactional
  public Task updateFinished(Integer id, Boolean finished) throws ErrorService{
    Optional<Task> response = taskRepository.findById(id);
    if(response.isPresent()){
      Task task = response.get();
      task.setFinished(finished);
      return taskRepository.save(task);
    }
    throw new ErrorService("The task id was not found");
  }
  
  @Transactional
  public void removeTask(Integer id) throws ErrorService{
    Optional<Task> response = taskRepository.findById(id);
    if(response.isPresent()){
      Task task = response.get();
      taskRepository.delete(task);
    }else{
      throw new ErrorService("The task id was not found");
    }
  }
  
  @Transactional
  public void removeAllByFolder(Integer id) throws ErrorService{
    folderService.findById(id);
    taskRepository.removeAllByFolder(id);
  }
  
  @Transactional(readOnly = true)
  public List<Task> listTasks(){
    return taskRepository.findAll();
  }
  
  @Transactional(readOnly = true)
  public List<Task> listTasksByFolder(Integer idFolder) throws ErrorService{
    folderService.findById(idFolder);
    return taskRepository.listTasksByFolder(idFolder);
    
  }
  
  @Transactional(readOnly = true)
  public Task findById(Integer id) throws ErrorService{
    Optional<Task> response = taskRepository.findById(id);
    if(response.isPresent()){
      return response.get();
    }
    throw new ErrorService("The task id was not found");
  }
}
