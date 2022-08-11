package com.todolist.ToDoList.controllers;

import com.todolist.ToDoList.entities.Folder;
import com.todolist.ToDoList.entities.Task;
import com.todolist.ToDoList.exceptions.ErrorService;
import com.todolist.ToDoList.services.FolderService;
import com.todolist.ToDoList.services.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/folders")
public class FolderController {

  @Autowired
  private FolderService folderService;

  @Autowired
  private TaskService taskService;

  @GetMapping
  public List<Folder> getFolders() {
    return folderService.listFolders();
  }

  @GetMapping("/{id}")
  public Folder getFolder(@PathVariable Integer id) throws ErrorService {
    return folderService.findById(id);
  }

  @PostMapping("/create")
  public Folder createFolder(@RequestBody String name) throws ErrorService {
    return folderService.createFolder(name);
  }

  @PutMapping("/update/{id}/{name}")
  public Folder updateFolder(@PathVariable Integer id, @PathVariable String name) throws ErrorService {
    return folderService.updateName(id, name);
  }

  @PutMapping("/update")
  public Folder updateFolder(@RequestBody Folder folder) throws ErrorService {
    return folderService.updateFolder(folder);
  }

  @DeleteMapping("/delete/{id}")
  public String removeFolder(@PathVariable Integer id) throws ErrorService {
    taskService.removeAllByFolder(id);
    folderService.removeFolder(id);
    return "Folder deleted successfully";
  }

  @DeleteMapping("/delete")
  public String removeFolder(@RequestBody Folder folder) throws ErrorService {
    taskService.removeAllByFolder(folder.getId());
    folderService.removeFolder(folder);
    return "Folder deleted successfully";
  }

  @GetMapping("/{id}/tasks")
  public List<Task> getFolderTasks(@PathVariable Integer id) throws ErrorService {
    return taskService.listTasksByFolder(id);
  }
}
