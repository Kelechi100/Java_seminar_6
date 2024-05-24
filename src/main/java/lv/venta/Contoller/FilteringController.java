package lv.venta.Contoller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.Service.IFilteringService;
import lv.venta.model.Grade;

@Controller
@RequestMapping("/filter")
public class FilteringController {
	
	@Autowired
	private IFilteringService filteringService;
	
	
	@GetMapping("/grade/failed")
	public String getfilterGradesFailed( Model model) {
		try
		{
			 ArrayList<Grade> dataFromSevice = filteringService.selectFailedGradesInSystem();
			 model.addAttribute("mypackage", dataFromSevice);
			 return "show-all-grades"; 
		}
		catch(Exception e) {
			
		model.addAttribute("mypackage", e.getMessage());
		return "error-page"; // this will show error-page.html page with exception message
		
		// TOOD : Handle Exception
	}
		

		 
	}

}
