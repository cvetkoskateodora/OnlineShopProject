package com.onlineshop.service;
import com.onlineshop.model.users;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.onlineshop.repository.usersRepository;

@Service
public class usersService {
	
	
	private final usersRepository usersRepository;
	
	public usersService(usersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}
	
	public  users registeruser(String username, String email, String password, String registeras) {
		
		if (username == null && password == null) {
			return null; 
			} else {
			 users users = new  users();
			 users.setUsername(username);
			 users.setEmail(email);
			 users.setPassword(password);
			 users.setRegisteras(registeras);
			return usersRepository.save(users);
		}
	}
	public  users authenticate (String email, String password) {
		return usersRepository.findByEmailAndPassword(email, password).orElse(null);
	}
}
