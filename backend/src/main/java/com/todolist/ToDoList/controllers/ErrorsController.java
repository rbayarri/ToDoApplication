package com.todolist.ToDoList.controllers;

import com.todolist.ToDoList.exceptions.ErrorService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorsController extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = {ErrorService.class})
  protected ResponseEntity<Object> handlerConfict(ErrorService e, WebRequest request) {
    String response = e.getMessage();
    return handleExceptionInternal(e,response,new HttpHeaders(),HttpStatus.CONFLICT,request);
  }
}
