package kodlama.io.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.business.auth.concretes.JobAdvertisementAuthManager;
import kodlama.io.hrms.core.results.DataResult;
import kodlama.io.hrms.core.results.ErrorDataResult;
import kodlama.io.hrms.core.results.ErrorResult;
import kodlama.io.hrms.core.results.Result;
import kodlama.io.hrms.core.results.SuccessDataResult;
import kodlama.io.hrms.core.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlama.io.hrms.entities.concretes.City;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.concretes.JobPosition;
import kodlama.io.hrms.entities.concretes.TypeOfWorking;
import kodlama.io.hrms.entities.concretes.WayOfWorking;
import kodlama.io.hrms.entities.dtos.JobPostingAddDto;

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


//	@Override
//	public Result add(JobAdvertisement jobAdvertisement) {
//		/*if(!jobAdvertisementAuthManager.checkJobDescription(jobAdvertisement)) {
//            return new ErrorDataResult<JobAdvertisement>("İş tanımı boş olamaz!");
//        }
//        else if(!jobAdvertisementAuthManager.checkOpenPositions(jobAdvertisement)) {
//            return new ErrorDataResult<JobAdvertisement>("Açık Pozisyon Sayısını Giriniz");
//        }
//        else if(!jobAdvertisementAuthManager.checkAdvertisementsDeadline(jobAdvertisement)) {
//            return new ErrorDataResult<JobAdvertisement>("Geçerli bir son başvuru tarihi giriniz!");
//        }
//        else if(!jobAdvertisementAuthManager.checkCreationDate(jobAdvertisement)) {
//            return new ErrorDataResult<JobAdvertisement>("Oluşturulma Tarihi Boş Bırakılamaz");
//        }
//        else if(!jobAdvertisementAuthManager.checkSalary(jobAdvertisement)) {
//            return new ErrorDataResult<JobAdvertisement>("Maksimum maaş minumum maaştan küçük olamaz!");
//        }*/
//		if (!jobAdvertisementAuthManager.CheckIfNullField(jobAdvertisement)) {
//			return new ErrorResult("You have entered missing information. Please fill in all fields.");
//		}
//		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.save(jobAdvertisement),"İş ilanı eklendi!");
//	}



	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll());

	}


	@Override
	public DataResult<List<JobAdvertisement>> getAllIsActiveJobAdvertisement() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllActiveJobAdvertisementList());
	}


	@Override
	public Result changeActiveToPasive(int id) {
		if (getById(id) == null) {
			return new ErrorResult("There is no such job advertisement");

		}
		if (getById(id).getData().getIsActive() == false) {
			return new ErrorResult("There job advertisement is already closed.");
		}

		JobAdvertisement jobAdvertisement = getById(id).getData();
		jobAdvertisement.setIsActive(false);
		update(jobAdvertisement);
		return new SuccessResult("Job advertisement has been successfully closed.");
	}
	
	@Override
	public Result changePasiveToActive(int id) {
		if (getById(id) == null) {
			return new ErrorResult("There is no such job advertisement");

		}
		if (getById(id).getData().getIsActive() == true) {
			return new ErrorResult("There job advertisement is already opened.");
		}

		JobAdvertisement jobAdvertisement = getById(id).getData();
		jobAdvertisement.setIsActive(true);
		update(jobAdvertisement);
		return new SuccessResult("Job advertisement has been successfully closed.");
	}


	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getByJobAdvertisementId(id));

	}


	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByAdvertisementsDeadline() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrueOrderByAdvertisementsDeadline());
	}


	@Override
	public DataResult<List<JobAdvertisement>> getByIsOpenAndId(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveAndEmployer_Id(true, employerId));
	}


	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job advertisement has been updated.");
	}


	@Override
	public Result add(JobPostingAddDto jobPostingAddDto) {
		JobAdvertisement jobAdvertisement = new JobAdvertisement(0, jobPostingAddDto.getJobDescription(), jobPostingAddDto.getMinSalary(),
				jobPostingAddDto.getMaxSalary(), jobPostingAddDto.getOpenPositionCount(),
				jobPostingAddDto.getApplicationDeadline(), false, null,
				new Employer(jobPostingAddDto.getEmployerId(), null, null, false, null, null, null, false),
				new JobPosition(jobPostingAddDto.getJobPositionId(), null, null),
				new City(jobPostingAddDto.getCityId(), null, null),
				new TypeOfWorking(jobPostingAddDto.getTypeOfWorkingId(), null, null),
				new WayOfWorking(jobPostingAddDto.getWayOfWorkingId(), null, null));
		
//		if (!jobAdvertisementAuthManager.CheckIfNullField(jobAdvertisement)) {
//			return new ErrorResult("You have entered missing information. Please fill in all fields.");
//		}
		
		jobAdvertisement.setIsActive(false);
		jobAdvertisement.setCreationDate(LocalDate.now());
//		jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.save(jobAdvertisement),"İş ilanı eklendi!");
		
	}


	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveFalseOrderByAdvertisementsDeadline() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrueOrderByAdvertisementsDeadline());

	}


	@Override
	public DataResult<List<JobAdvertisement>> getAllIsPasiveJobAdvertisement() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllPasiveJobAdvertisementList());

	}




}
