package kodlama.io.hrms.repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.User;

public interface UserRepostory extends JpaRepository<User, Integer> {
	
	List<User> findByMail(String email);

}
