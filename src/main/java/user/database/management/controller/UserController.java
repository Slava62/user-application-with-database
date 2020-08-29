package user.database.management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import user.database.management.model.User;
import user.database.management.services.UserService;


@RestController
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	 @GetMapping("/")
	    public User addNewUser(@RequestParam Long id, String name, String email){

	        return userService.addUser(id, name, email);

	    }

}
