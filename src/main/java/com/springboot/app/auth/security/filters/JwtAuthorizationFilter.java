package com.springboot.app.auth.security.filters;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.springboot.app.auth.jwt.JwtUtils;
import com.springboot.app.auth.service.UserDetailsServiceImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter{
	private final JwtUtils jwtUtils;
	private final UserDetailsServiceImpl userDetailsService;
	
	
	public JwtAuthorizationFilter(JwtUtils jwtUtils, UserDetailsServiceImpl userDetailsService) {
		super();
		this.jwtUtils = jwtUtils;
		this.userDetailsService = userDetailsService;
	}


	@Override
	protected void doFilterInternal(@NotNull HttpServletRequest request, 
			@NotNull HttpServletResponse response, 
			@NotNull FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tokenHeader=request.getHeader("Authorization");
		if(tokenHeader!=null && tokenHeader.startsWith("Bearer ")) {
			String token=tokenHeader.substring(7,tokenHeader.length());
			if(jwtUtils.isTokenValid(token)) {
				String email=jwtUtils.getEmail(token);
				UserDetails userDetails=userDetailsService.loadUserByUsername(email);
				UsernamePasswordAuthenticationToken authenticationToken= 
						new UsernamePasswordAuthenticationToken(email,null,userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		}
		filterChain.doFilter(request, response);
	}

}
