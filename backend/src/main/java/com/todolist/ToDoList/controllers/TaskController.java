package com.todolist.ToDoList.controllers;

import com.todolist.ToDoList.entities.Task;
import com.todolist.ToDoList.exceptions.ErrorService;
import com.todolist.ToDoList.services.TaskService;
import com.todolist.ToDoList.validations.Validations;
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
@RequestMapping("/tasks")
public class TaskController {

  @Autowired
  private TaskService taskService;

  @GetMapping
  public List<Task> getTasks() {
    return taskService.listTasks();
  }

  @GetMapping("/{id}")
  public Task getTask(@PathVariable Integer id) throws ErrorService {
    return taskService.findById(id);
  }

  @PostMapping("/create")
  public Task createTask(@RequestBody Task task) throws ErrorService {
    Validations.validateString(task.getDescription());
    return taskService.createTask(task);
  }

  @PutMapping("/update/{id}/{description}/{finishedString}")
  public Task updateTask(@PathVariable Integer id, @PathVariable String description, @PathVariable String finishedString) throws ErrorService {
    Validations.validateString(description);
    Boolean finished = Boolean.parseBoolean(finishedString);
    taskService.updateDescription(id, description);
    return taskService.updateFinished(id, finished);
  }
  
  @PutMapping("/update")
  public Task updateTask(@RequestBody Task task) throws ErrorService{
    Validations.validateString(task.getDescription());
    return taskService.updateTask(task);
  }

  @DeleteMapping("/delete/{id}")
  public String removeTask(@PathVariable Integer id) throws ErrorService {
    taskService.removeTask(id);
    return "Task deleted successfully";
  }
  
  @DeleteMapping("/delete")
  public String removeTask(@RequestBody Task task) throws ErrorService {
    taskService.removeTask(task.getId());
    return "Task deleted successfully";
  }

}
