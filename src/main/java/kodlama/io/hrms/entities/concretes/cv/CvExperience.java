package kodlama.io.hrms.entities.concretes.cv;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_seekers_experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class CvExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "workplace_name")
    private String workplaceName;

    @Column(name = "position")
    private String position;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "leave_date")
    private LocalDate leaveDate;
    
    @Column(name="is_quited")
	private boolean isQuited;

 // @JsonProperty(access = Access.WRITE_ONLY)
 // @JsonIgnoreProperties()
    @ManyToOne(targetEntity = Cv.class)
    @JsonIgnore()
    @JoinColumn(name="cv_id")
    private Cv cv;
    
}
