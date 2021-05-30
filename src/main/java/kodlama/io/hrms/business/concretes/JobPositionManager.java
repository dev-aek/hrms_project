package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobPositionAuthService;
import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.core.results.DataResult;
import kodlama.io.hrms.core.results.ErrorDataResult;
import kodlama.io.hrms.core.results.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.JobPositionDao;
import kodlama.io.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	
    private JobPositionAuthService jobPositionAuthService;
    private JobPositionDao jobPositionDao;

    @Autowired // Otamatik new'lemeye yarıyor..
    public JobPositionManager(JobPositionDao jobPositionDao, JobPositionAuthService jobPositionAuthService) {
        super();
        this.jobPositionDao = jobPositionDao;
        this.jobPositionAuthService=jobPositionAuthService;
    }
    
    

    @Override
    public DataResult<List<JobPosition>> getAll() {

        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "İş Pozisyonları Listelendi");
    }



	@Override
	public DataResult<JobPosition> add(JobPosition jobPosition) {
		
		if(jobPositionAuthService.checkJobPositionName(jobPosition.getJobPositionName())) {
            return new ErrorDataResult<JobPosition>("Bu İş Pozisyonu Eklenemez");
        }
		
		return new SuccessDataResult<JobPosition>(this.jobPositionDao.save(jobPosition),"İş pozisyonu eklendi.");

	}





}