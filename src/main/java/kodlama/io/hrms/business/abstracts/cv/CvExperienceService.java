package kodlama.io.hrms.business.abstracts.cv;

import java.util.List;

import kodlama.io.hrms.core.results.DataResult;
import kodlama.io.hrms.entities.concretes.cv.CvExperience;

public interface CvExperienceService {

	DataResult<List<CvExperience>> getAll();
	DataResult<List<CvExperience>> orderCvExperiencesByStartDateDesc(int id);

}
