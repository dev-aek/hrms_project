package kodlama.io.hrms.core.adapters;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.abstracts.IMailService;
import kodlama.io.hrms.services.FakeMailService;
@Service
public class JMailVerificationAdapter implements IMailService{
	

    @Override
    public boolean isValid(String email)
    {
        return FakeMailService.isOkay(email);
    }
    
}
