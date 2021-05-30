package kodlama.io.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobSeekerAuthService;
import kodlama.io.hrms.core.abstracts.IIdentityValidService;
import kodlama.io.hrms.core.abstracts.IMailService;
import kodlama.io.hrms.dataAccess.abstracts.IUserDao;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerAuthManager extends AuthManager implements JobSeekerAuthService {
	
	private JobSeekerDao jobSeekerDao;
	IIdentityValidService mernisService;

	
	@Autowired
	public JobSeekerAuthManager(IMailService emailService, IIdentityValidService mernisService, IUserDao userDao,JobSeekerDao jobSeekerDao) {
		super(emailService, userDao);
		this.jobSeekerDao= jobSeekerDao;
		this.mernisService = mernisService;
	}

	@Override
    public boolean checkFirstName(JobSeeker jobSeeker) {
        if(jobSeeker.getFirstName().isBlank() || jobSeeker.getFirstName().equals(null)) {
        return false;
        }
        return true;
    }

    @Override
    public boolean checkLastName(JobSeeker jobSeeker) {

        if(jobSeeker.getLastName().isBlank() || jobSeeker.getLastName().equals(null)) {
        return false;
        }
        return true;
    }

    @Override
    public boolean checkBirthDate(JobSeeker jobSeeker) {
        if(jobSeeker.getBirthDate().equals(null)) {
        return false;
        }
        return true;
    }

    
    @Override
	public boolean checkIdentityNumber(String identityNumber) {
		if (!this.mernisService.isValid(identityNumber)) {
			return false;
		}
		
		if (!this.jobSeekerDao.findAllByNationalityId(identityNumber).isEmpty()) {
			return false;
		}
		
		return true;
	}
    
}
