package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.core.results.DataResult;
import kodlama.io.hrms.core.results.ErrorDataResult;
import kodlama.io.hrms.core.results.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	private EmployerDao employerDao;
    private EmployerAuthManager employerAuthManager;
    
    @Autowired
    public EmployerManager(EmployerDao employerDao,EmployerAuthManager employerAuthManager) {
		super();
		this.employerDao = employerDao;
		this.employerAuthManager = employerAuthManager;
	}

	@Override
	public DataResult<Employer> add(Employer employer, String passwordRepeat) {
		
		if(!employerAuthManager.checkCompanyName(employer)) {
            return new ErrorDataResult<Employer>("Şirket Adınız Onaylanmadı!");
        }
        else if(!employerAuthManager.checkPhoneNumber(employer)) {
            return new ErrorDataResult<Employer>("Telefon Numaranız geçersiz!");
        }
        else if(!employerAuthManager.checkWebSite(employer)) {
            return new ErrorDataResult<Employer>("Website adresiniz geçersiz!");
        }
        else if(!employerAuthManager.checkEmail(employer.getMail())) {
            return new ErrorDataResult<Employer>("Mail geçersiz!");
        }
        else if(!employerAuthManager.checkPassword(employer)) {
            return new ErrorDataResult<Employer>("Şifre Geçersiz");
        }
        else if(!employerAuthManager.checkPasswordRepeat(employer,passwordRepeat)) {
            return new ErrorDataResult<Employer>("Şifre Tekrarı Geçersiz!");
        }		
		return new SuccessDataResult<Employer>(this.employerDao.save(employer),"İş veren eklendi . Doğrulandı.");
	}

	@Override
	public DataResult<List<Employer>> getAll() {

        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "İş verenler listelendi.");
	}

}
