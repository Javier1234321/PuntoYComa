package com.springboot.app.auth.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.app.auth.dao.UserDao;
import com.springboot.app.auth.entity.UserEntity;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDao userDao;

    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        UserEntity userEntity = userDao.findByEmail(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "El usuario no existe"
                        )
                );

        GrantedAuthority authority =
                new SimpleGrantedAuthority(
                        "ROLE_".concat(
                                userEntity.getRol().getName()
                        )
                );

        return new User(
                userEntity.getEmail(),
                userEntity.getPassword(),
                true,
                true,
                true,
                true,
                List.of(authority)
        );
    }
}