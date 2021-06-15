package kodlama.io.hrms.repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.concretes.JobAdvertisement;
public interface JobAdvertisementRepostory extends JpaRepository<JobAdvertisement, Integer> {
	
	
	@Query("From JobAdvertisement where isActive = true")
	List<JobAdvertisement> getAllActiveJobAdvertisementList();
	
	@Query("From JobAdvertisement where isActive = false")
	List<JobAdvertisement> getAllPasiveJobAdvertisementList();
	
	//@Query("From JobAdvert where isOpen = true Order By publishedAt Desc")
	List<JobAdvertisement>  findByIsActiveTrueOrderByAdvertisementsDeadline(); 
		
	//@Query("From JobAdvert where isOpen = true and employer_id =:id")
	List<JobAdvertisement> getByIsActiveAndEmployer_Id(boolean isActive, int employerId);
		
	JobAdvertisement getByJobAdvertisementId(int id);
	
	//@Query("From JobAdvert where isOpen = false Order By publishedAt Desc")
	List<JobAdvertisement>  findByIsActiveFalseOrderByAdvertisementsDeadline();

}
