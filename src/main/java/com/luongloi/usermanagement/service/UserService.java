package com.luongloi.usermanagement.service;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luongloi.usermanagement.model.User;
import com.luongloi.usermanagement.model.dto.UserDTO;
import com.luongloi.usermanagement.model.mapper.UserMapper;
import com.luongloi.usermanagement.respository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	
	  public UserService(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }

	    public User createUser(User user) {
	        return userRepository.save(user);
	    }

//	    public List<User> getAllUsers() {
//	        return userRepository.findAll();
//	    }
	    
	    public List<UserDTO> getAllUsers() {
	    	List<UserDTO> listUserDTO = new ArrayList<>();
	    	for (User user : userRepository.findAll()) {
	    		listUserDTO.add(UserMapper.toUserDTO(user));
	    	}
	    	return listUserDTO;
	    }

//	    public User getUserById(int id) {
//	        return userRepository.findById(id).orElse(null);
//	    }

	    public UserDTO getUserById(int id) {
	    	UserDTO userDto = UserMapper.toUserDTO(userRepository.findById(id).orElse(null));
	        return userDto;
	    }
	    
	    public void deleteUser(int id) {
	        userRepository.deleteById(id);
	    }
}
