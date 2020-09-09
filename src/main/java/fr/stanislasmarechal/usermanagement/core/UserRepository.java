package fr.stanislasmarechal.usermanagement.core;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.stanislasmarechal.usermanagement.model.User;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends JpaRepository<User, Long>  {

	List<User> findByFirstName(@Param("firstName") String firstName);

	List<User> findByEmail(@Param("email") String email);
	
	List<User> findByAddress(@Param("address") String address);
	
}
