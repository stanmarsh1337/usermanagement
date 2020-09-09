package fr.stanislasmarechal.usermanagement.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import fr.stanislasmarechal.usermanagement.model.User;

@RepositoryEventHandler(User.class)
public class UserEventHandler {

	@Autowired
	Sender sender;
	
	public UserEventHandler() {
	}
	
	@HandleAfterCreate
	public void handleUserAfterCreate(User user) {
		sender.sendMessage("User with id: " + user.getId() +  " has been created");
	}

	@HandleAfterDelete
	public void handleUserAfterDelete(User user) {
		sender.sendMessage("User with id: " + user.getId() +  " has been deleted");
	}
	
	@HandleAfterSave
	public void handleUserAfterSave(User user) {
		sender.sendMessage("User with id: " + user.getId() +  " has been updated");
	}
}