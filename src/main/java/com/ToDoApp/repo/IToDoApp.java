package com.ToDoApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ToDoApp.model.ToDo;

@Repository
public interface IToDoApp extends JpaRepository <ToDo,Long>  {
   
}
