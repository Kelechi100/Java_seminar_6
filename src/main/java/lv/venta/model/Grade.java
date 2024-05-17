package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "GradesTable")
@Entity

public class Grade {
	//Varaibles
		@Setter(value = AccessLevel.NONE)
		@Column(name = "G_Id")
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long g_id;
		
		@Min(4)
		@Max(10)
		@Column(name = "Score")
		private int gradevalue;
		
		
		//Creating Linkage between two classes(Grade Courses)
		@OneToOne(mappedBy = "") // need to specify the varaiable title
		@ToString.Exclude // Used to stop unending loop between linked classes
		private Course course;
		
		
		//Creating Linkage between two classes(Grades/ Student)
		@ManyToOne// need to specify the varaiable title
		@JoinColumn(name = "STID")
		private Student student;
			
		public Grade(int gradevalue) {
			setGradevalue(gradevalue);
		}

}
