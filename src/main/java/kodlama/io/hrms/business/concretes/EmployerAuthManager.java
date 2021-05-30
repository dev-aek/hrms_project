package kodlama.io.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployerAuthService;
import kodlama.io.hrms.core.abstracts.IMailService;
import kodlama.io.hrms.dataAccess.abstracts.IUserDao;
import kodlama.io.hrms.entities.concretes.Employer;

@Service
public class EmployerAuthManager extends AuthManager  implements EmployerAuthService{
	
	@Autowired
	public EmployerAuthManager(IMailService emailService, IUserDao userDao) {
		super(emailService, userDao);
	}

	@Override
	public boolean checkCompanyName(Employer employer) {
		if(employer.getCompanyName().isBlank() || employer.getCompanyName().equals(null)) {
	        return false;
	        }
	        return true;
	}

	@Override
	public boolean checkPhoneNumber(Employer employer) {
		if(employer.getPhoneNumber().isBlank() || employer.getPhoneNumber().equals(null)) {
	        return false;
	        }
	        return true;
	}

	@Override
	public boolean checkWebSite(Employer employer) {
		if(employer.getWebSite().isBlank() || employer.getWebSite().equals(null)) {
	        return false;
	        }
	        return true;
	}
	

}
