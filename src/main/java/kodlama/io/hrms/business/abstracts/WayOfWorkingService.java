package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.results.DataResult;
import kodlama.io.hrms.core.results.Result;
import kodlama.io.hrms.entities.concretes.WayOfWorking;

public interface WayOfWorkingService {

	Result add(WayOfWorking wayOfWorking);

	DataResult<List<WayOfWorking>> getAll();

}