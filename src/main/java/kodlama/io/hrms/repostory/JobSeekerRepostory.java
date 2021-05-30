package kodlama.io.hrms.repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.JobSeeker;

public interface JobSeekerRepostory extends JpaRepository<JobSeeker, Integer> {
	
	//List<JobSeeker> findAllByMail(String email);

    List<JobSeeker> findAllByNationalityId(String tcno);

}
