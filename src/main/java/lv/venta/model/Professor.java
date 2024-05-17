package lv.venta.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ProfessorTable")
@Entity
public class Professor {
	//variables
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idp")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idp;
	
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z]+")
	@Size(min = 2, max =20)
	@Column(name = "Name")
	private String name;
	
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z]+")
	@Size(min = 2, max =10)
	@Column(name = "Surname")
	private String Surname;
	
	@NotNull
	@Column(name = "Degree")
	private Degree degree;
	
	
	//Creating Linkage between two classes(Professor/ Courses)
	@OneToOne(mappedBy = "professor") // need to specify the varaiable title
	@ToString.Exclude // Used to stop unending loop between linked classes
	private Course course;
	
	public Professor(String name, String Surname, Degree degree) {
		setName(name);
		setSurname(Surname);
		setDegree(degree);
	}
	

}
