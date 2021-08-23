package io.javabrains.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.javabrains.dao.UserRepository;
import io.javabrains.model.MyUserDetail;
import io.javabrains.model.User;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {
		Optional< User > user = userRepository.findByUserName( username );
		
		user.orElseThrow(() -> new UsernameNotFoundException( "User not found: " + username ));
		
		return user.map( MyUserDetail::new ).get();
	}

}
