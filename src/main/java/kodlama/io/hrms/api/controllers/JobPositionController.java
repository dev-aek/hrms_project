package kodlama.io.hrms.api.controllers;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.core.results.DataResult;
import kodlama.io.hrms.core.results.Result;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobs")
public class JobPositionController {

	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionController(JobPositionService jobService) {
		super();
		this.jobPositionService = jobService;
	}
	
	@PostMapping("/add")
    public Result add(@RequestBody JobPosition jobPosition)
    {
        return this.jobPositionService.add(jobPosition);
    }
	
	@GetMapping("/getall")
    public DataResult<List<JobPosition>> getAll()
    {
        return this.jobPositionService.getAll();
    }
}
