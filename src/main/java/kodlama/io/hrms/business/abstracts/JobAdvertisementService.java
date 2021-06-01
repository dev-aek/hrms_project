package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.results.DataResult;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	DataResult<JobAdvertisement> add(JobAdvertisement jobAdvertisement);

}
