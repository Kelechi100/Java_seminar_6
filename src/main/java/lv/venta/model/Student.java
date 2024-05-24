package lv.venta.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "StudentTable")
@Entity

public class Student {
	// Variables
	@Setter(value = AccessLevel.NONE)
	@Column(name = "STID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long stid;

	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z]+")
	@Size(min = 2, max = 20)
	@Column(name = "Name")
	private String name;

	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z]+")
	@Size(min = 2, max = 10)
	@Column(name = "Surname")
	private String Surname;

	@OneToMany(mappedBy = "student") // need to specify title of variable
	@ToString.Exclude // Used to stop unending loop between linked classes
	private Collection<Grade> grades;

	// Adding an arug Constructor
	public Student(String name, String Surname) {
		setName(name);
		setSurname(Surname);
	}

}
