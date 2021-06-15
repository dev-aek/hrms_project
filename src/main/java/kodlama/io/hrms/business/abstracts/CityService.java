package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.results.DataResult;
import kodlama.io.hrms.entities.concretes.City;

public interface CityService {

	 DataResult<List<City>> getAll();
}
