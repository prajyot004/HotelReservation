package com.example.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.User;
import com.example.Service.Impl.MyUserDetailService;

@RestController
public class SignUpController {

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	MyUserDetailService myUserDetailService;
	
	@PostMapping("/users")
	public User adduser( @RequestBody User user) {
		String password = user.getPassword();
		String encodedPassword = bCryptPasswordEncoder.encode(password);
		user.setPassword(encodedPassword);
		return myUserDetailService.addUser(user);
	}
	
	
	
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
		return myUserDetailService.getUserById(id);
	}
	
	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable int id) {
		myUserDetailService.deleteUser(id);
		return "User Deleted";
	}
	
	@GetMapping("/users")
	public List<User> getallusers(){
		return  myUserDetailService.getallUser();
	}
}
