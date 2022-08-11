package com.todolist.ToDoList.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
public class Task {
  
  @Id
  @GeneratedValue
  private Integer id;
  
  private String description;
  private Boolean finished;
  
  @ManyToOne
  private Folder folder;  
  
}
