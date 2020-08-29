package user.database.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import user.database.management.model.User;

import java.util.List;

	// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
	// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
}
	

