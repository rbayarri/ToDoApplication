package com.todolist.ToDoList.controllers;

import com.todolist.ToDoList.entities.Folder;
import com.todolist.ToDoList.entities.Task;
import com.todolist.ToDoList.exceptions.ErrorService;
import com.todolist.ToDoList.services.FolderService;
import com.todolist.ToDoList.services.TaskService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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

  @GetMapping("/")
  public List<Folder> getFolders2() {
    return folderService.listFolders();
  }

  @GetMapping("/{id}")
  public Folder getFolder(@PathVariable Integer id) throws ErrorService {
    return folderService.findById(id);
  }

  @GetMapping("/create/{name}")
  public ResponseEntity createFolder(@PathVariable String name) throws ErrorService, URISyntaxException {
    Folder folder = folderService.createFolder(name);
    return ResponseEntity.created(new URI("/folders/" + folder.getId())).body(folder);
  }
  
  @GetMapping("/update/{id}/{name}")
  public ResponseEntity updateFolder(@PathVariable Integer id, @PathVariable String name) throws ErrorService {
    Folder folder = folderService.updateName(id, name);
    return ResponseEntity.ok(folder);
  }

  @GetMapping("/delete/{id}")
  public ResponseEntity removeFolder(@PathVariable Integer id) throws ErrorService {
    taskService.removeAllByFolder(id);
    folderService.removeFolder(id);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/{id}/tasks")
  public List<Task> getFolderTasks(@PathVariable Integer id) throws ErrorService {
    return taskService.listTasksByFolder(id);
  }
}
