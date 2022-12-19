package ro.digitalnation.warmhome.service;

import java.util.List;

import ro.digitalnation.warmhome.models.User;

public interface UserService {
	
	List<User> getAllUsers();
	User saveUser(User user);
	User updateUser(User user);
	User getUserById(Long id);
	User getUserByRole(String role);
	void deleteUserById(Long id);
}
