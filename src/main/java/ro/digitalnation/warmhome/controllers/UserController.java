package ro.digitalnation.warmhome.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;
import ro.digitalnation.warmhome.models.User;
import ro.digitalnation.warmhome.service.UserService;
import ro.digitalnation.warmhome.util.UserDto;

@Controller
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/login")
    public String loginForm() {
        return "login";
    }
	

	@GetMapping("/cms/users")
	public String listUsers(Model model) {
		List<UserDto> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "users";
	}

	// handler method to handle user registration form request
	@GetMapping("/register")
	public String createUserForm(Model model) {
		// create model object to store form data

		UserDto user = new UserDto();
		model.addAttribute("user", user);
		return "create_user";
	}

	// handler method to handle register user form submit request
	@PostMapping("/register/save")
	public String registration(@Valid @ModelAttribute("user") UserDto user, BindingResult result, Model model) {
		User existing = userService.findByEmail(user.getEmail());
		if (existing != null) {
			result.rejectValue("email", null, "There is already an account registered with that email");
		}
		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "create_user";
		}
		userService.saveUser(user);
		return "redirect:/register?success";
	}

}
