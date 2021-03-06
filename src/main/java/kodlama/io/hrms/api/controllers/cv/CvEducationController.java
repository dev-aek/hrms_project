package kodlama.io.hrms.api.controllers.cv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kodlama.io.hrms.business.abstracts.cv.CvEducationService;
import kodlama.io.hrms.core.results.DataResult;
import kodlama.io.hrms.core.results.Result;
import kodlama.io.hrms.entities.concretes.cv.CvEducation;

import java.util.List;

@RestController
@RequestMapping("/api/CvEducations")
public class CvEducationController {

    private CvEducationService cvEducationService;

    @Autowired
    public CvEducationController(CvEducationService cvEducationService) {
        super();
        this.cvEducationService = cvEducationService;
    }

    @GetMapping("/getAll")
	public DataResult<List<CvEducation>> getAll() {
		return this.cvEducationService.getAll();
	}
	
	@GetMapping("/getByCandidateCvId")
	public DataResult<List<CvEducation>> getByJobSeekerCvId(@RequestParam int id) {
		return this.cvEducationService.getByCvId(id);
	}
	
	@PostMapping("/update")
	public DataResult<CvEducation> update(@RequestBody CvEducation cvEducation) {
		return this.cvEducationService.update(cvEducation);
	}
	
	@PostMapping("/addSchoolToCv")
	public Result add(@RequestBody CvEducation cvEducation,@RequestParam int jobSeekerId) {
		return this.cvEducationService.addSchoolToCv(cvEducation, jobSeekerId);
	}
	
	@GetMapping("/getCandidateSchoolsByGraduationDateDesc")
	public DataResult<List<CvEducation>> orderCvEducationsByGraduationYearDesc(int id) {
		return this.cvEducationService.orderCvEducationsByGraduationYearDesc(id);
	}

}
