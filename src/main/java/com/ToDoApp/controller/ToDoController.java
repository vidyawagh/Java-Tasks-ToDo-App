package com.ToDoApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ToDoApp.model.ToDo;
import com.ToDoApp.service.ToDoService;

@Controller
public class ToDoController {


@Autowired
private ToDoService service;

@GetMapping({"/", "viewToDoItem"})
public String viewAllToDoItems(Model model, @ModelAttribute("message") String message) {
	model.addAttribute("list", service.getAllToDoItems());
	model.addAttribute("message", message);
	
	return "ViewToDoList";    //jsp Page 
}

	
	@GetMapping("/updateToDoStatus/{id}")
	public String updateToDoStatus(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		if(service.updateStatus(id)) {
			redirectAttributes.addFlashAttribute("message", "update success");
			return"redirect:/viewToDoItem";
		}
		redirectAttributes.addFlashAttribute("message", "update failure");
		return "redirect:/viewToDoItem";
	}
 
	@GetMapping("/addToDoItem")
	public String addToDoItems(Model model) {
		model.addAttribute("todo", new ToDo());
		return "AddToDoItem";    //Jsp page
		
	}
	@PostMapping("/saveToDoItem")
	public String saveToDoItem(ToDo todo,RedirectAttributes redirectAttributes) {
		if(service.saveOrUpdateToDoItems(todo)) {
			redirectAttributes.addFlashAttribute("message", "save success");
			return "redirect:/viewToDoItem";

		}
		redirectAttributes.addFlashAttribute("message", "save Failure");
		return "redirect:/addToDoItem";
		
	}
	

	@GetMapping("/editToDoItem/{id}")
	public String editToDoItem(@PathVariable Long id, Model model) {
		model.addAttribute("todo", service.getToDoItemById(id));
		return "EditToDoItem";   //Jsp Page
		
	}
	@PostMapping("/editSaveToDoItem")
	public String editsaveToDoItem(ToDo todo , RedirectAttributes redirctAttributes) {
		if(service.saveOrUpdateToDoItems(todo)) {
			redirctAttributes.addFlashAttribute("message", "Edit success");
			return "redirect:/viewToDoItem";

		}
		redirctAttributes.addFlashAttribute("message", "Edit Failure");
		return "redirect:/editToDoItem/" + todo.getId();
	
	}	
	
	@GetMapping("/deleteToDoItem/{id}")
	public String deleteToDoItem (@PathVariable Long id, RedirectAttributes redirectAttributes) {
		if(service.deleteToDoItems(id)) {
			redirectAttributes.addFlashAttribute("message", "Delete Success");
		      return "redirect:/viewToDoList";
		}
		redirectAttributes.addFlashAttribute("message","delete Failure");
		return "redirect:/viewToDoList";
	}

	
	
}


