package kodlama.io.hrms.business.auth.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.auth.abstracts.JobPositionAuthService;
import kodlama.io.hrms.dataAccess.abstracts.JobPositionDao;
@Service
public class JobPositionAuthManager implements JobPositionAuthService{
	
	JobPositionDao jobPositionDao;	
	
	@Autowired
	public JobPositionAuthManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}



	@Override
	public boolean checkJobPositionName(String jobPositionName) {
		if(jobPositionName.isBlank() || jobPositionName.equals(null)) {
	        return false;
	        }
		
		if (this.jobPositionDao.findAllByJobPositionName(jobPositionName).isEmpty()) {
			return false;
		}
	        return true;
	}
	

}
