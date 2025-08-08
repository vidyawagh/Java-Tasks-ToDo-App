package com.ToDoApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ToDoApp.model.ToDo;
import com.ToDoApp.repo.IToDoApp;

@Service
public class ToDoService {

    
	@Autowired
	IToDoApp repo;

	public List<ToDo> getAllToDoItems(){
		 ArrayList<ToDo> todoList = new ArrayList<>();
		 repo.findAll().forEach(todo -> todoList.add(todo));
		 return todoList;
		
	}
	  public ToDo getToDoItemById(Long id) {
		  return repo.findById(id).get();
	  }
	   
     public boolean updateStatus(Long id){
          ToDo todo	= getToDoItemById(id);
          todo.setStatus("completed");
          return saveOrUpdateToDoItems(todo);
		
	}
	

	public boolean saveOrUpdateToDoItems(ToDo todo){
		   ToDo updateobj = repo.save(todo);
		   
		   if (getToDoItemById(updateobj.getId()) != null)
		   {
			   return true;
		   }
		   return false;
	}
	
	  
	public boolean deleteToDoItems(Long id){
		
	
		repo.deleteById(id);
		
		if (repo.findById(id).isEmpty()) {
			return true;
		}
		return false;
		
	}

}
