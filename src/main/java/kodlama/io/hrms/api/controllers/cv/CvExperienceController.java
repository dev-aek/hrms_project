package kodlama.io.hrms.api.controllers.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.cv.CvExperienceService;
import kodlama.io.hrms.core.results.DataResult;
import kodlama.io.hrms.entities.concretes.cv.CvExperience;

@RestController
@RequestMapping("/api/cvexperiences")
public class CvExperienceController {

	private CvExperienceService cvExperienceService;

	@Autowired
	public CvExperienceController(CvExperienceService cvExperienceService) {
		super();
		this.cvExperienceService = cvExperienceService;
	}
	

	@GetMapping("/getAll")
	public DataResult<List<CvExperience>> getAll() {
		return this.cvExperienceService.getAll();
	}
	
	@GetMapping("/getCvExperiencesByStartDateDesc")
	public DataResult<List<CvExperience>> orderCvExperienceByStarDateDesc(int id) {
		return this.cvExperienceService.orderCvExperiencesByStartDateDesc(id);
	}
	
}