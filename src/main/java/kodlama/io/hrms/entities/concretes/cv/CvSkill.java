package kodlama.io.hrms.entities.concretes.cv;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_seekers_skills")
@EqualsAndHashCode(callSuper = false)
public class CvSkill {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonProperty(access = Access.WRITE_ONLY)
    @ManyToOne(targetEntity = Cv.class)
    @JsonIgnore()
    @JoinColumn(name = "cv_id")
    private Cv cv;
    
    @ManyToOne
	@JoinColumn(name="skills_id")
	private Skill skill;
    
    
    public CvSkill (Cv cv, Skill skill) {
		this.skill = skill;
		this.cv = cv;
	}
}