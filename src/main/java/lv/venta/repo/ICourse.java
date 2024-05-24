package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Course;

public interface ICourse extends CrudRepository<Course, Long> {

	ArrayList<Course> findByProfessorIds(long id);

	ArrayList<Course> findByGradesStudentIds(long id);

}
