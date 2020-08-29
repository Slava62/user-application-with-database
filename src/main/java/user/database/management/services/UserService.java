package user.database.management.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import user.database.management.model.User;
import user.database.management.repository.UserRepository;


@Service
@Transactional
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public User addUser(Long id, String name, String email) {
		 User n = new User();
		 	n.setId(id.intValue());
		    n.setName(name);
		    n.setEmail(email);
		    return userRepository.save(n);
	}
	
	public User getById(Long id) {
		return userRepository.getOne(id);
	}
}
