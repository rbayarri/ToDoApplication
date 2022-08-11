package com.todolist.ToDoList.exceptions;

public class ErrorService extends Exception {

  public ErrorService() {
  }

  public ErrorService(String msg) {
    super(msg);
  }
}
