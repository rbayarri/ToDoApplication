package com.todolist.ToDoList.repositories;

import com.todolist.ToDoList.entities.Task;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer>{
  
  @Query("SELECT t FROM Task t WHERE t.folder.id = :idFolder")
  public List<Task> listTasksByFolder(@Param("idFolder") Integer idFolder);
  
  @Modifying
  @Query("DELETE FROM Task t WHERE t.folder.id = :idFolder")
  public void removeAllByFolder(@Param("idFolder") Integer idFolder);
}
