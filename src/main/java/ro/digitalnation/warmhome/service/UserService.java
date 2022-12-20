package ro.digitalnation.warmhome.service;

import java.util.List;

import ro.digitalnation.warmhome.models.User;
import ro.digitalnation.warmhome.util.UserDto;

public interface UserService {

	List<UserDto> getAllUsers();

	void saveUser(UserDto userDto);	

	User getUserById(Long id);	
	
	//for spring security use
	User findByEmail(String email);
}
