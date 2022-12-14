package ro.digitalnation.warmhome.service.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ro.digitalnation.warmhome.models.Role;
import ro.digitalnation.warmhome.models.User;
import ro.digitalnation.warmhome.repository.UserRepository;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

	private UserRepository userRepository;

	public CustomUserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);

		/*
		 * if (user != null) { return new
		 * org.springframework.security.core.userdetails.User(user.getEmail(),
		 * user.getPassword(), mapRolesToAuthorities(user.getRoles())); } else { throw
		 * new UsernameNotFoundException("Invalid username or password."); }
		 */
		
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(),
				  user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		Collection<? extends GrantedAuthority> mapRoles = roles.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		return mapRoles;
	}

}
