package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.results.DataResult;
import kodlama.io.hrms.core.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.dtos.JobPostingAddDto;

@CrossOrigin
@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementController {
	
	JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	/* @GetMapping("/getallActiveAdvertisements")
	    public DataResult<List<JobAdvertisement>> getAll()
	    {
	        return this.jobAdvertisementService.getAll();
	    }*/
	
	@PostMapping("/add_job_advertisement")
	    public Result add(@RequestBody JobPostingAddDto jobPostingAddDto)
	    {
	        return this.jobAdvertisementService.add(jobPostingAddDto);
	    }
	 
	@GetMapping("/getall")
	public  DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}

	
	@GetMapping("/getAllIsActiveJobAdvertList")
	public DataResult<List<JobAdvertisement>> getAllIsActiveJobAdvertisementList(){
		return this.jobAdvertisementService.getAllIsActiveJobAdvertisement();
	}
	
	@GetMapping("/getAllIsPasiveJobAdvertList")
	public DataResult<List<JobAdvertisement>> getAllIsPasiveJobAdvertisementList(){
		return this.jobAdvertisementService.getAllIsPasiveJobAdvertisement();
	}
	
	@GetMapping("/getbyid")
	public DataResult<JobAdvertisement> getById(int id){
		return this.jobAdvertisementService.getById(id);
	}
	

	@PostMapping("/changeActiveToPasive")
	public Result changeActiveToPasive(int id){
		return this.jobAdvertisementService.changeActiveToPasive(id);
	}
	
	@PostMapping("/changePasiveToActive")
	public Result changePasiveToActive(int id){
		return this.jobAdvertisementService.changePasiveToActive(id);
	}
	
	
	@GetMapping("/findAllByOrderByEmployerAt")
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByAdvertisementsDeadline (){
		return this.jobAdvertisementService.findByIsActiveTrueOrderByAdvertisementsDeadline();
	}
	
	@GetMapping("/findAllIsActiveFalseByOrderByEmployerAt")
	public DataResult<List<JobAdvertisement>> findByIsActiveFalseOrderByAdvertisementsDeadline (){
		return this.jobAdvertisementService.findByIsActiveFalseOrderByAdvertisementsDeadline();
	}
	
	@GetMapping("/getAllOpenJobAdvertByEmployer")
	public DataResult<List<JobAdvertisement>> getByIsOpenJobAdvertisementOrderByEmployer_Id(@RequestParam int id){
		return this.jobAdvertisementService.getByIsOpenAndId(id);
	}

}
