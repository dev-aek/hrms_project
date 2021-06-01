package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.results.DataResult;
import kodlama.io.hrms.core.results.Result;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {
	
	EmployerService employerService;
	JobAdvertisementService jobAdvertisementService;
	
	 @Autowired
	    public EmployerController(EmployerService employerService, JobAdvertisementService jobAdvertisementService)
	    {
	        this.employerService = employerService;
	        this.jobAdvertisementService=jobAdvertisementService;
	    }

	    @GetMapping("/getall")
	    public DataResult<List<Employer>> getAll()
	    {
	        return this.employerService.getAll();
	    }

	    @PostMapping("/add")
	    public Result add(@RequestBody Employer employer, String passwordRepeat)
	    {
	        return this.employerService.add(employer,passwordRepeat);
	    }
	    
	    @PostMapping("/add_job_advertisement")
	    public Result add(@RequestBody JobAdvertisement jobAdvertisement)
	    {
	        return this.jobAdvertisementService.add(jobAdvertisement);
	    }
	    
	    @GetMapping("/getallAdvertisement")
		public  DataResult<List<JobAdvertisement>> getAllAdvertisement(){
			return this.jobAdvertisementService.getAll();
		}
	   

}
