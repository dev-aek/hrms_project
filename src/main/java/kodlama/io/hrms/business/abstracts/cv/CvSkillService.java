package kodlama.io.hrms.business.abstracts.cv;

import java.util.List;

import kodlama.io.hrms.core.results.DataResult;
import kodlama.io.hrms.core.results.Result;
import kodlama.io.hrms.entities.concretes.cv.CvSkill;
import kodlama.io.hrms.entities.concretes.cv.Skill;

public interface CvSkillService {

	DataResult<List<CvSkill>> getAll();
	
	DataResult<List<CvSkill>> getByCvId(int id);
	
	Result addSkillToCv(Skill skill, int jobSeekerId); 	
}