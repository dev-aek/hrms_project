package kodlama.io.hrms.business.abstracts.cv;

import java.util.List;

import kodlama.io.hrms.core.results.DataResult;
import kodlama.io.hrms.core.results.Result;
import kodlama.io.hrms.entities.concretes.cv.CvEducation;

public interface CvEducationService {

DataResult<List<CvEducation>> getAll();
	
	DataResult<List<CvEducation>> getByCvId(int id);
	
	DataResult<CvEducation> update(CvEducation cvEducation);
	
	Result addSchoolToCv(CvEducation cvSchool, int jobSeekerId);
	
	DataResult<List<CvEducation>> orderCvEducationsByGraduationYearDesc(int id);
    //DataResult<List<CvEducation>> getAllByJobSeekerIdAndOrderingEndingYear(boolean isAscending, int jobSeekerId);
}
