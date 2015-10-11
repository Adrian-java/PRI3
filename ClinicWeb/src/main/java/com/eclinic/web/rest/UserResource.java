package com.eclinic.web.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.eclinic.service.TokenTransfer;
import com.eclinic.web.rest.security.TokenUtils;

@Path("/auth")
@Component("UserResource")
public class UserResource {

	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authManager;
	
	@Autowired
	private UserDetailsService userService;
	
	@Path("/token")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public TokenTransfer authenticate(@FormParam("username") String username, @FormParam("password") String password)
	{
		UsernamePasswordAuthenticationToken authenticationToken =
				new UsernamePasswordAuthenticationToken(username, password);
		Authentication authentication = this.authManager.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetails userDetails = this.userService.loadUserByUsername(username);

		return new TokenTransfer(TokenUtils.createToken(userDetails));
	}
}
