package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Grade;

public interface IGrade extends CrudRepository<Grade, Long> {
	//public abstract  by default

	ArrayList<Grade> findByGrValueLessThan(int i);

	ArrayList<Grade> findByStudentIds(long id);

}
