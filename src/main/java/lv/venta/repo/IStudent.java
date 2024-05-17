package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Student;

public interface IStudent extends CrudRepository<Student, Long>{
	

}
