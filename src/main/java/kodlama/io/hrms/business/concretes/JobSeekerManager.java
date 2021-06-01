package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.business.auth.concretes.JobSeekerAuthManager;
import kodlama.io.hrms.core.results.DataResult;
import kodlama.io.hrms.core.results.ErrorDataResult;
import kodlama.io.hrms.core.results.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{

    private JobSeekerDao jobSeekerDao;
    private JobSeekerAuthManager JobSeekerAuthManager;
    
    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao,JobSeekerAuthManager jobSeekerAuthManager) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		JobSeekerAuthManager = jobSeekerAuthManager;
	}

	@Override
    public DataResult<JobSeeker> add(JobSeeker jobSeeker, String passwordRepeat) {

        if(!JobSeekerAuthManager.checkFirstName(jobSeeker)) {
            return new ErrorDataResult<JobSeeker>("Ad boş bırakılamaz.");
        }
        else if(!JobSeekerAuthManager.checkLastName(jobSeeker)) {
            return new ErrorDataResult<JobSeeker>("Soyad boş bırakılamaz.");
        }
        else if(!JobSeekerAuthManager.checkBirthDate(jobSeeker)) {
            return new ErrorDataResult<JobSeeker>("Doğum tarihi boş bırakılamaz.");
        }
        else if (!JobSeekerAuthManager.checkEmail(jobSeeker.getMail()) ) {
        	return new ErrorDataResult<JobSeeker>("mail dikkat et.");
        }
        else if(!JobSeekerAuthManager.checkPassword(jobSeeker)) {
            return new ErrorDataResult<JobSeeker>("Şifre boş bırakılamaz.");
        }
        else if(!JobSeekerAuthManager.checkIdentityNumber(jobSeeker.getNationalityId())) {
        	return new ErrorDataResult<JobSeeker>("tc dikkat et.");

        }
        else if (!JobSeekerAuthManager.checkPasswordRepeat(jobSeeker,passwordRepeat)) {
        	return new ErrorDataResult<JobSeeker>("Parolanızı tekrar doğru bir şekilde giriniz!");
		}
        else {
            return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.save(jobSeeker),"İş arayan hesabı eklendi . Doğrulandı.");
            
		}
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {

        return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "İş arayanlar listelendi.");

    }
}