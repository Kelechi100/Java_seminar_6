package lv.venta.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "CourseTable")
@Entity
public class Course {
	// Varaibles
	@Setter(value = AccessLevel.NONE)
	@Column(name = "C_Id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long C_id;

	@NotNull
	@Pattern(regexp = "[A-Za-z ]+")
	@Size(min = 5, max = 20)
	@Column(name = "Title")
	private String title;

	@Min(1)
	@Max(20)
	@Column(name = "Creditpoints")
	private int creditpoints;

	// Creating Linkage between two classes
	@OneToOne
	@JoinColumn(name = "Idp") // need to specify column name
	private Professor professor;

	@OneToMany(mappedBy = "course") // need to specify title of variable
	@ToString.Exclude // Used to stop unending loop between linked classes
	private Collection<Grade> gradevalue;

	public Course(String title, int creditpoints, Professor professsor) {
		setTitle(title);
		setCreditpoints(creditpoints);
		setProfessor(professsor);
	}

}
