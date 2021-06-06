package kodlama.io.hrms.core.imageService;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.core.results.DataResult;

public interface ImageService {

	DataResult<Map> upload(MultipartFile multipartFile) throws IOException;
	DataResult<Map> delete(String id) throws IOException;
}
