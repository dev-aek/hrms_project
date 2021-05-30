package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.results.DataResult;
import kodlama.io.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {

	DataResult<JobSeeker> add(JobSeeker jobSeeker, String passwordRepeat);
	DataResult<List<JobSeeker>> getAll();
}
