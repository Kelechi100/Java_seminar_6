package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Course;
import lv.venta.model.Degree;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import lv.venta.repo.ICourse;
import lv.venta.repo.IGrade;
import lv.venta.repo.IProfessor;
import lv.venta.repo.IStudent;

@SpringBootApplication
public class Seminar6Application {

	public static void main(String[] args) {
		SpringApplication.run(Seminar6Application.class, args);
	}
	@Bean
	public CommandLineRunner testDataBase(IProfessor professorRepo,  IGrade gradeRepo,  ICourse courseRepo, IStudent studentRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Professor P1 = new Professor("Estere", "Vitola", Degree.phd);
				Professor P2 = new Professor("Karina", "Skimante", Degree.ms);
				professorRepo.save(P1);
				professorRepo.save(P2);
				
				Student s1 = new Student("Mike", "Peter");
				Student s2 = new Student("Mike", "Paul");
				studentRepo.save(s1);
				studentRepo.save(s2);
				
				Course c1 = new Course("Java Programming", 6, P2);
				Course c2 = new Course("Data Structures", 4, P1);
				courseRepo.save(c1);
				courseRepo.save(c2);
				
				
				Grade  g1 = new Grade(6, s1, c1);
				Grade g2 = new Grade( 7, s2, c1);
				Grade g3 = new Grade( 10, s1, c2);
				Grade g4 = new Grade( 7, s2, c2);
				gradeRepo.save(g1);
				gradeRepo.save(g2);
				gradeRepo.save(g3);
				gradeRepo.save(g4);
				
			
				// TODO Auto-generated method stub
				
			}
		};
	}

}
