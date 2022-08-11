package com.todolist.ToDoList.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
public class Folder {
  
  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE)
  private Integer id;
  
  private String name;
  
}
