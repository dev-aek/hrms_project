package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.results.DataResult;
import kodlama.io.hrms.core.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.dtos.JobPostingAddDto;

public interface JobAdvertisementService {
	
	Result add(JobPostingAddDto jobPostingAddDto);
	Result update(JobAdvertisement jobAdversitement);
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getAllIsActiveJobAdvertisement();
	DataResult<List<JobAdvertisement>> getAllIsPasiveJobAdvertisement();

	
	Result changeActiveToPasive(int id);
	Result changePasiveToActive(int id);
	DataResult<JobAdvertisement> getById(int id);
	DataResult<List<JobAdvertisement>>  findByIsActiveTrueOrderByAdvertisementsDeadline();
	DataResult<List<JobAdvertisement>>  findByIsActiveFalseOrderByAdvertisementsDeadline();
	DataResult<List<JobAdvertisement>> getByIsOpenAndId( int employerId);
	


}
