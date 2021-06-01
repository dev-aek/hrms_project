package kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name="employers")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","advertisements"})
public class Employer extends User{
   

    @Column(name="company_name") 
    private String companyName;

    @Column(name="phone_number") 
    private String phoneNumber;

    @Column(name="web_site") 
    private String webSite;

   @Column(name="verify_system") 
    private boolean verifySystem;
   
   @OneToMany(mappedBy ="employer")
	private List<JobAdvertisement> advertisements;

   @Autowired
	public Employer(String mail, String password, String companyName, String phoneNumber, String webSite,
			boolean verifySystem) {
		super(mail, password);
		this.companyName = companyName;
		this.phoneNumber = phoneNumber;
		this.webSite = webSite;
		this.verifySystem = verifySystem;
	}
    
    
}