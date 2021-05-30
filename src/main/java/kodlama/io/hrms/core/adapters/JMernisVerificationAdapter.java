package kodlama.io.hrms.core.adapters;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.abstracts.IIdentityValidService;
import kodlama.io.hrms.services.FakeMernis;
@Service
public class JMernisVerificationAdapter implements IIdentityValidService {
	
	
	@Override
	public boolean isValid(String tcno) {
		return FakeMernis.validate(tcno);
	}

}
