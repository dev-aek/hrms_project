package kodlama.io.hrms.business.auth.abstracts;

import kodlama.io.hrms.entities.concretes.User;

public interface AuthService {
	
	boolean checkEmail(String email);
	boolean checkPassword(User user);
	boolean checkPasswordRepeat(User user, String passwordRepeat);


}
