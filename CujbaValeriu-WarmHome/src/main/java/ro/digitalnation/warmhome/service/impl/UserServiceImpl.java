package ro.digitalnation.warmhome.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.digitalnation.warmhome.models.User;
import ro.digitalnation.warmhome.repository.UserRepository;
import ro.digitalnation.warmhome.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		
		return userRepository.findById(id).get();
	}

	@Override
	public User getUserByRole(String role) {
		User user = new User();
		return user;
	}

	@Override
	public void deleteUserById(Long id) {
		
		userRepository.delete(userRepository.findById(id).get());
	}

}
