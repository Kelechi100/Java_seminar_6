package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Professor;

public interface IProfessor extends CrudRepository<Professor, Long> {

}
