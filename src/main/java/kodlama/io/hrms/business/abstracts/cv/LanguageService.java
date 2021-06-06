package kodlama.io.hrms.business.abstracts.cv;

import java.util.List;

import kodlama.io.hrms.core.results.DataResult;
import kodlama.io.hrms.core.results.Result;
import kodlama.io.hrms.entities.concretes.cv.Language;

public interface LanguageService {

	DataResult<List<Language>> getAll();
	
	Result add(Language language);
}
