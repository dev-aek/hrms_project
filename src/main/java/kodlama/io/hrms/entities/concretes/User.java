package kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="users")
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name="mail") 
    private String mail;

    @Column(name="password") 
    private String password;

    @Column(name="confirm") 
    private boolean confirm;
    
    @Autowired
    public User(String mail, String password, boolean confirm) {
		this.mail = mail;
		this.password = password;
		this.confirm = confirm;
	}
    
    @Autowired
	public User(int id, String mail, String password, boolean confirm) {
		super();
		this.id = id;
		this.mail = mail;
		this.password = password;
		this.confirm = confirm;
	}
    
    
}