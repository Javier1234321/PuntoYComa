package com.springboot.app.auth.security.filters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.springboot.app.auth.entity.UserEntity;
import com.springboot.app.auth.jwt.JwtUtils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.core.exc.StreamReadException;
import tools.jackson.databind.DatabindException;
import tools.jackson.databind.ObjectMapper;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	private final JwtUtils jwtUtils;
	
	public JwtAuthenticationFilter(JwtUtils jwt) {
		this.jwtUtils=jwt;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		UserEntity userEntity=null;
		String email;
		String password;
		try{
			userEntity= new ObjectMapper().readValue(request.getInputStream(), UserEntity.class);
			email=userEntity.getEmail();
			password=userEntity.getPassword();
		}catch(StreamReadException e) {
			throw new RuntimeException(e);
			
		}catch(DatabindException e) {
			throw new RuntimeException(e);
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
		UsernamePasswordAuthenticationToken auth= new UsernamePasswordAuthenticationToken(email,password);
		// TODO Auto-generated method stub
		return getAuthenticationManager().authenticate(auth);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		User user=(User) authResult.getPrincipal();
		String token=jwtUtils.generateAccessToken(user.getUsername());
		response.addHeader("Authorization", token);
		Map<String, Object> httpResponse=new HashMap<>();
		httpResponse.put("token", token);
		httpResponse.put("Message", "Autenticacion correcta");
		httpResponse.put("email", user.getUsername());
		response.getWriter().write(new ObjectMapper().writeValueAsString(httpResponse));
		response.setStatus(HttpStatus.OK.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.getWriter().flush();
		super.successfulAuthentication(request, response, chain, authResult);
	}
	
}
