package kodlama.io.hrms.repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.JobSeeker;

public interface EmployerRepostroy extends JpaRepository<Employer, Integer>{
	
    List<JobSeeker> findAllByPhoneNumber(String phoneNumber);


}
