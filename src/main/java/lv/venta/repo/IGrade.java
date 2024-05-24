package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Grade;

public interface IGrade extends CrudRepository<Grade, Long> {
	//public abstract  by default

	ArrayList<Grade> findByGradevalueLessThan(int i);
	//public abstract  by default

	ArrayList<Grade> findByStudentStid(long id);
	
	// public abstract by default
	@Query(nativeQuery = true, value = "select avg(score) from grades_table where c_id=2")

	float calculateAVGGraade_MyFunction(long id);

}
