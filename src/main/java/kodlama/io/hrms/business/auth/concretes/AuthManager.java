package kodlama.io.hrms.business.auth.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.auth.abstracts.AuthService;
import kodlama.io.hrms.core.abstracts.IMailService;
import kodlama.io.hrms.dataAccess.abstracts.IUserDao;
import kodlama.io.hrms.entities.concretes.User;
import lombok.Data;

@Data
@Service
public class AuthManager implements AuthService{

	IUserDao userDao;
	IMailService emailService;
	
	private String messageDetail = "";
	
	
	@Autowired
	public AuthManager(IMailService emailService, IUserDao userDao)
	{
		this.emailService = emailService;
		this.userDao = userDao;
	}
	
	

	@Override
	public boolean checkEmail(String email) {
		
		this.messageDetail = "";
		
		if (!this.emailService.isValid(email)) {
			
			this.messageDetail += "Gerçek bir email adresi girmeniz gerekmektedir.";
			return false;
			
		}
		
		if (!this.userDao.findByMail(email).isEmpty()) {
			this.messageDetail += "Girdiğiniz mail zaten sisteme kayıtlı.";
			return false;
		}
		
		return true;
	}

	
	@Override
	public boolean checkPasswordRepeat(User user, String passwordRepeat) {
		this.messageDetail = "";
		if (!passwordRepeat.equals(user.getPassword()) || passwordRepeat.equals("")) {
			this.messageDetail += "Parolanızı tekrar doğru bir şekilde giriniz.";
			return false;
			}
		else {
		return true;
	}

}

	@Override
	public boolean checkPassword(User user) {
		if(user.getPassword().isBlank() || user.getPassword().equals(null)) {
	        return false;
	        }
	        return true;
	}

	
	
	public String getMessageDetail(String messageDetail) {
		this.messageDetail = messageDetail;
		 return this.messageDetail;
	}

}
