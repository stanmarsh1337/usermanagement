package fr.stanislasmarechal.usermanagement.api;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.stanislasmarechal.usermanagement.core.UserRepository;
import fr.stanislasmarechal.usermanagement.model.User;

@RestController
public class UserAPI {
	private UserRepository repository;
	
	public UserAPI(UserRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/toto")
	public Collection<User> users(){
		return repository.findAll();
	}
	
}
