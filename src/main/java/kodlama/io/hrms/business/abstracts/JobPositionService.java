package kodlama.io.hrms.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Component;

import kodlama.io.hrms.core.results.DataResult;
import kodlama.io.hrms.entities.concretes.JobPosition;
@Component
public interface JobPositionService {

	DataResult<JobPosition> add(JobPosition jobPosition);
	DataResult<List<JobPosition>> getAll(); 
}
