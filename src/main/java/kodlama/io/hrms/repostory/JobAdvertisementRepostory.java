package kodlama.io.hrms.repostory;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementRepostory extends JpaRepository<JobAdvertisement, Integer> {
	

}
