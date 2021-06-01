package kodlama.io.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.business.auth.concretes.JobAdvertisementAuthManager;
import kodlama.io.hrms.core.results.DataResult;
import kodlama.io.hrms.core.results.ErrorDataResult;
import kodlama.io.hrms.core.results.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	private JobAdvertisementDao jobAdvertisementDao;
    private JobAdvertisementAuthManager jobAdvertisementAuthManager;

    @Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, JobAdvertisementAuthManager jobAdvertisementAuthManager) {
		super();
		this.jobAdvertisementAuthManager = jobAdvertisementAuthManager;
		this.jobAdvertisementDao = jobAdvertisementDao;
	}


	@Override
	public DataResult<JobAdvertisement> add(JobAdvertisement jobAdvertisement) {
		if(!jobAdvertisementAuthManager.checkJobDescription(jobAdvertisement)) {
            return new ErrorDataResult<JobAdvertisement>("İş tanımı boş olamaz!");
        }
        else if(!jobAdvertisementAuthManager.checkOpenPositions(jobAdvertisement)) {
            return new ErrorDataResult<JobAdvertisement>("Açık Pozisyon Sayısını Giriniz");
        }
        else if(!jobAdvertisementAuthManager.checkAdvertisementsDeadline(jobAdvertisement)) {
            return new ErrorDataResult<JobAdvertisement>("Geçerli bir son başvuru tarihi giriniz!");
        }
        else if(!jobAdvertisementAuthManager.checkCreationDate(jobAdvertisement)) {
            return new ErrorDataResult<JobAdvertisement>("Oluşturulma Tarihi Boş Bırakılamaz");
        }
        else if(!jobAdvertisementAuthManager.checkSalary(jobAdvertisement)) {
            return new ErrorDataResult<JobAdvertisement>("Maksimum maaş minumum maaştan küçük olamaz!");
        }
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.save(jobAdvertisement),"İş ilanı eklendi!");
	}

}
