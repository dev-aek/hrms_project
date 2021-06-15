package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.TypeOfWorkingService;
import kodlama.io.hrms.core.results.DataResult;
import kodlama.io.hrms.core.results.Result;
import kodlama.io.hrms.core.results.SuccessDataResult;
import kodlama.io.hrms.core.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.TypeOfWorkingDao;
import kodlama.io.hrms.entities.concretes.TypeOfWorking;

@Service
public class TypeOfWorkingManager implements TypeOfWorkingService {

	private TypeOfWorkingDao typeOfWorkingDao;

	@Autowired
	public TypeOfWorkingManager(TypeOfWorkingDao typeOfWorkingDao) {
		super();
		this.typeOfWorkingDao = typeOfWorkingDao;
	}

	@Override
	public Result add(TypeOfWorking typeOfWorking) {
		typeOfWorkingDao.save(typeOfWorking);
		return new SuccessResult("Çalışma türü eklendi");
	}

	@Override
	public DataResult<List<TypeOfWorking>> getAll() {
		return new SuccessDataResult<List<TypeOfWorking>>(typeOfWorkingDao.findAll());
	}

}
