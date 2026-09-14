package com.springboot.app.auth.mappers;

import com.springboot.app.auth.models.dto.UserDTO;
import com.springboot.app.auth.models.entity.User;

public class UserMapper {
	public static UserDTO toDTO(User user) {
		UserDTO dto= new UserDTO();
		dto.setId(user.getId());
		dto.setEmail(user.getEmail());
		dto.setLastName(user.getLastName());
		dto.setName(user.getName());
		dto.setPassword(user.getPassword());
		dto.setRol(user.getRol().getRol());
		return dto;
	};
}
