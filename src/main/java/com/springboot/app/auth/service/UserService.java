package com.springboot.app.auth.service;

import org.springframework.stereotype.Service;

import com.springboot.app.auth.dao.RolDAO;
import com.springboot.app.auth.dao.UserDAO;
import com.springboot.app.auth.mappers.UserMapper;
import com.springboot.app.auth.models.dto.UserDTO;
import com.springboot.app.auth.models.entity.User;

@Service
public class UserService {
	private final UserDAO userDao;
	private final RolDAO rolDao;
	
	
	public UserService(UserDAO userDao, RolDAO rolDao) {
		super();
		this.userDao = userDao;
		this.rolDao = rolDao;
	}


	public UserDTO find(String email, String password) {
		User user=userDao.findUserByEmailAndPassword(email, password);
		UserDTO dto=UserMapper.toDTO(user);
		return dto;
	}
}
