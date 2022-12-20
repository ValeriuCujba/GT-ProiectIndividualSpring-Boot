package ro.digitalnation.warmhome.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ro.digitalnation.warmhome.models.Role;
import ro.digitalnation.warmhome.models.User;
import ro.digitalnation.warmhome.repository.RoleRepository;
import ro.digitalnation.warmhome.repository.UserRepository;
import ro.digitalnation.warmhome.service.UserService;
import ro.digitalnation.warmhome.util.UserDto;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
			PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void saveUser(UserDto userDto) {
		User user = new User();
		user.setName(userDto.getFirstName() + " " + userDto.getLastName());
		user.setEmail(userDto.getEmail());
		// encrypt the password using spring security
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));

		// creaza un ADMIN cu gmail = admin@gmail.com si parola = "parola"
//		Role role = null;
//		if (userDto.getEmail().equals("admin@gmail.com")) {
//			role = createAdminRole();
//		} else {
		Role role = roleRepository.findByName("ROLE_CUSTOMER");
			if (role == null) {
				role = checkRoleExist();
//			}
		}
		user.setRoles(Arrays.asList(role));
		userRepository.save(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();
		return users.stream().map((user) -> convertEntityToDto(user)).collect(Collectors.toList());
	}

	@Override
	public User getUserById(Long id) {

		return userRepository.findById(id).get();
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	private UserDto convertEntityToDto(User user) {
		UserDto userDto = new UserDto();
		String[] name = user.getName().split(" ");
		userDto.setFirstName(name[0]);
		userDto.setLastName(name[1]);
		userDto.setEmail(user.getEmail());
		return userDto;
	}

	private Role checkRoleExist() {
		Role role = new Role();
		role.setName("ROLE_CUSTOMER");
		return roleRepository.save(role);
	}

	private Role createAdminRole() {
		Role role = new Role();
		role.setName("ROLE_ADMIN");
		return roleRepository.save(role);
	}

}
