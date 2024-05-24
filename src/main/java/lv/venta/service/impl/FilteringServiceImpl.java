package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.Service.IFilteringService;
import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.repo.ICourse;
import lv.venta.repo.IGrade;
import lv.venta.repo.IProfessor;
import lv.venta.repo.IStudent;	

@Service
public class FilteringServiceImpl implements IFilteringService {
	@Autowired
	private IGrade gradeRepo;
	@Autowired
	private IStudent studentRepo;
	@Autowired
	private IProfessor professorRepo;
	@Autowired
	private ICourse courseRepo;

	@Override
	public ArrayList<Grade> selectFailedGradesInSystem() throws Exception {
		ArrayList<Grade> result = gradeRepo.findByGradevalueLessThan(4);
		if (result.isEmpty()) {
			throw new Exception("All grades passed");
		}

		return result;
	}

	@Override
	public ArrayList<Grade> selectGradesByStudentId(long id) throws Exception {
		if (id < 1) {
			throw new Exception("Id should be positive");
		}

		if (!studentRepo.existsById(id)) {
			throw new Exception("student with id (" + id + ") is not in the system");
		}
		
	
		ArrayList<Grade> result = gradeRepo.findByStudentStid(id);
		if (result.isEmpty()) {
			throw new Exception("student with id (" + id + ") is not in the system");
		}
		return result;

	}

	@Override
	public ArrayList<Course> selectCourseByStudent(long id) throws Exception {
		if (id < 1) {
			throw new Exception("Id Should be positve");
			
		}
		if (!studentRepo.existsById(id)) {
			throw new Exception ("student with id (" + id + ") is not in the system");
		}
		ArrayList<Course> result =  courseRepo.findByGradevalueStudentStid(id); // classes and three tables were used to cerate this variable
		
		if(result.isEmpty()) {
			throw new Exception ("student with id (" + id + ") is not in the system");
		}

		return result;
	}

	@Override
	public ArrayList<Course> selectCoursesByProfessorId(long id) throws Exception {
		if (id < 1) {
			throw new Exception("Id Should be positve");
			
		}
		if (!professorRepo.existsById(id)) {
			throw new Exception ("Profesor with id (" + id + ") is not in the system");
		}
		ArrayList<Course> result =  courseRepo.findByProfessorIdp(id);
		if (result.isEmpty()) {
			throw new Exception  ("Profesor with id (" + id + ") has no course");
		}	
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public float calculateAVGGradeInCourse(long id) throws Exception {
		if (id < 1) {
			throw new Exception("Id Should be positve");
		}
		
		
		if (!courseRepo.existsById(id)) {
			throw new Exception ("Course with id (" + id + ") is not in the system");
		}
		
		float result = gradeRepo.calculateAVGGraade_MyFunction(id);
		if(result == 0) {
			throw new Exception ("there is no grade in this course");
		
			
	
		}
		return  result;
	}
}


