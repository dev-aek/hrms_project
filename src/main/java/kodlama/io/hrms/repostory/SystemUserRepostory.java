package kodlama.io.hrms.repostory;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.SystemUser;

public interface SystemUserRepostory extends JpaRepository<SystemUser, Integer> {

}
