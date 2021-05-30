package kodlama.io.hrms.repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.JobPosition;
import kodlama.io.hrms.entities.concretes.JobSeeker;

public interface JobPositionRepostory extends JpaRepository<JobPosition, Integer>{
	
    List<JobPosition> findAllByJobPositionName(String jobPositionName);
    //yorum


}
