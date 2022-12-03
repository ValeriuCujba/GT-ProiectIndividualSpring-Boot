package ro.digitalnation.warmhome.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ro.digitalnation.warmhome.models.User;
import ro.digitalnation.warmhome.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@GetMapping("/users")
	public String listUsers(Model model) {
		model.addAttribute("listOfUsers", userService.getAllUsers());
		return "users";
	}
	
	@GetMapping("/users/new")
	public String createStudentForm(Model model) {
		
		//Create student object to hold student from data
		User user =  new User();
		model.addAttribute("user", user);		
		return "create_user";		
	}
	
	@PostMapping("/users")
	public String saveStudent(@ModelAttribute("user") User user) {
		userService.saveUser(user);		
		return "redirect:/users";			
	}
	
	
}
