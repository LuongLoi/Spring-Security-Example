package com.luongloi.usermanagement.model.mapper;

import com.luongloi.usermanagement.model.User;
import com.luongloi.usermanagement.model.dto.UserDTO;

public class UserMapper {
	
	public static UserDTO toUserDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUs_id(user.getUs_id());
		userDTO.setUsername(user.getUsername());
		userDTO.setUs_group(user.getGroup());
		return userDTO;	
	}
}
