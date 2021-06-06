package kodlama.io.hrms.business.abstracts.cv;

import java.util.List;

import kodlama.io.hrms.core.results.DataResult;
import kodlama.io.hrms.core.results.Result;
import kodlama.io.hrms.entities.concretes.cv.Skill;

public interface SkillService {

	DataResult<List<Skill>> getAll();
	
	Result add(Skill skill);
}
