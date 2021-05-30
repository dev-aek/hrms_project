package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.entities.concretes.User;

public interface AuthService {
	
	boolean checkEmail(String email);
	boolean checkPassword(User user);
	boolean checkPasswordRepeat(User user, String passwordRepeat);


}
