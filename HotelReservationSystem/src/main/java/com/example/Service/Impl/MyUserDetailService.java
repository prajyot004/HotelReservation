package com.example.Service.Impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Entity.Role;
import com.example.Entity.User;
import com.example.Repository.RoleRepository;
import com.example.Repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByname(username);
		if(user == null) {
			throw new UsernameNotFoundException("No user present with this username");
		}
		return new UserPrincipal(user);
	}
	
	public User addUser(User u) {
		
		Role role = new Role();
		role.setRname("user");
		Set<Role> st = new HashSet<>();
		st.add(role);
		if(u.getRoles() == null) {
			u.setRoles(st);
		}
		
		return userRepository.save(u);
	}
	
	public List<User> getallUser(){
		return userRepository.findAll();
	}
	
	public User getUserById(int id) {
		return userRepository.findById(id).get();
	}
	
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

}
