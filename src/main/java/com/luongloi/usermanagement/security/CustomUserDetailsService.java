package com.luongloi.usermanagement.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.luongloi.usermanagement.model.User;
import com.luongloi.usermanagement.respository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> o_user = userRepository.findByUsername(username);
		if (!o_user.isPresent())
			throw new UsernameNotFoundException("User not found");
		User user = o_user.get();
		user.setPassword(encoder.encode(user.getPassword()));
		return new CustomUserDetail(user);
	}

}
