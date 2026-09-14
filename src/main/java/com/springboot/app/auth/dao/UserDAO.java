package com.springboot.app.auth.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.app.auth.models.entity.User;

public interface UserDAO extends JpaRepository<User,Long>{
	@Query("""
			SELECT u FROM User u
			WHERE u.email LIKE (email) AND u.password=password
			""")
	User findUserByEmailAndPassword(@Param("email") String email,@Param("password") String password );
}
