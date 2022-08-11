package com.todolist.ToDoList.repositories;

import com.todolist.ToDoList.entities.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<Folder,Integer> {
  
}
