package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.results.DataResult;
import kodlama.io.hrms.core.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	Result add(JobAdvertisement jobAdvertisement);
	Result update(JobAdvertisement jobAdversitement);
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getAllIsActiveJobAdvertisement();
	
	
	Result changeActiveToPasive(int id);
	DataResult<JobAdvertisement> getById(int id);
	DataResult<List<JobAdvertisement>>  findByIsActiveTrueOrderByAdvertisementsDeadline();
	DataResult<List<JobAdvertisement>> getByIsOpenAndId( int employerId);
	


}
