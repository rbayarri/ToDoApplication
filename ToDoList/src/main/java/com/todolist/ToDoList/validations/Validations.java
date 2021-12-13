package com.todolist.ToDoList.validations;

import com.todolist.ToDoList.exceptions.ErrorService;

public class Validations {
  
  public static void validateString(String text) throws ErrorService{
    if(text == null || text.trim().isEmpty()){
      throw new ErrorService("Invalid text input");
    }
  }
  
}
