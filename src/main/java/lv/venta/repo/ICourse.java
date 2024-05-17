package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Course;

public interface ICourse extends CrudRepository<Course, Long> {

}
