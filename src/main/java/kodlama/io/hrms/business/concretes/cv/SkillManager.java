package kodlama.io.hrms.business.concretes.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.cv.SkillService;
import kodlama.io.hrms.core.results.DataResult;
import kodlama.io.hrms.core.results.Result;
import kodlama.io.hrms.core.results.SuccessDataResult;
import kodlama.io.hrms.core.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.cv.SkillDao;
import kodlama.io.hrms.entities.concretes.cv.Skill;

@Service
public class SkillManager implements SkillService{

	private SkillDao skillDao;
	
	@Autowired
	public SkillManager(SkillDao skillDao) {
		super();
		this.skillDao = skillDao;
	}

	@Override
	public DataResult<List<Skill>> getAll() {
		return new SuccessDataResult<List<Skill>>
		(this.skillDao.findAll(),"Yetenekler listelendi.");
	}

	@Override
	public Result add(Skill skill) {
		this.skillDao.save(skill);
		return new SuccessResult("yetenek eklendi.");
	}

}