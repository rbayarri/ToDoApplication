package com.todolist.ToDoList.controllers;

import com.todolist.ToDoList.entities.Task;
import com.todolist.ToDoList.exceptions.ErrorService;
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
@RequestMapping("/tasks")
public class TaskController {

  @Autowired
  private TaskService taskService;

  @GetMapping
  public List<Task> getTasks() {
    return taskService.listTasks();
  }

  @GetMapping("/")
  public List<Task> getTasks2() {
    return taskService.listTasks();
  }
  
  @GetMapping("/{id}")
  public Task getTask(@PathVariable Integer id) throws ErrorService{
    return taskService.findById(id);
  }

  @GetMapping("/create/{description}/{idFolder}")
  public ResponseEntity createTask(@PathVariable String description, @PathVariable Integer idFolder) throws ErrorService, URISyntaxException {
    Task task = taskService.createTask(description, idFolder);
    return ResponseEntity.created(new URI("/tasks/" + task.getId())).body(task);
  }

  @GetMapping("/update/{id}/{description}/{finishedString}")
  public ResponseEntity updateTask(@PathVariable Integer id, @PathVariable String description, @PathVariable String finishedString) throws ErrorService{
    Boolean finished = Boolean.parseBoolean(finishedString);
    taskService.updateDescription(id, description);
    Task task = taskService.updateFinished(id, finished);
    return ResponseEntity.ok(task);
  }
  
  @GetMapping("/delete/{id}")
  public ResponseEntity removeTask(@PathVariable Integer id) throws ErrorService{
    taskService.removeTask(id);
    return ResponseEntity.ok().build();
  }

}
