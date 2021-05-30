package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.results.DataResult;
import kodlama.io.hrms.entities.concretes.Employer;

public interface EmployerService {
	
	DataResult<Employer> add(Employer employer, String passwordRepeat);
	DataResult<List<Employer>> getAll();

}
