package com.app.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.validator.UomValidator;
import com.app.view.UomExcelView;
import com.app.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {

	private static final Logger log=Logger.getLogger(UomController.class);

	@Autowired
	private IUomService service;
	@Autowired
	private UomValidator validator;

	// 1.Display Register Page
	@RequestMapping("/register")
	public String showRegPage(ModelMap map) {
		map.addAttribute("uom", new Uom());
		return "UomRegister";

	}

	// 2.On click Submit Button
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String saveData(@ModelAttribute Uom uom,Errors errors, ModelMap map) {
		log.info("Entered into Uom Controller insert method");
		validator.validate(uom, errors);
		log.info("Validations are completed");
		if(!errors.hasErrors()) {
			log.info("No Errors found in save");
			try {
				Integer id = service.saveUom(uom);
				log.debug("Uom created with id:" +id);
				String msg = "Uom  '" + id + "' saved";
				map.addAttribute("message", msg);
				map.addAttribute("uom", new Uom());
			}catch(Exception e) {
				log.error("Exception" +e.getMessage());
				map.addAttribute("message", "Problem in Operation");	
			}
		}
		log.info("About leave Uom Controller");
		return "UomRegister";

	}

	// 3. getdata from db to UI
	@RequestMapping("/all")
	public String showData(ModelMap map) {
		List<Uom> um = service.getAllUoms();
		map.addAttribute("list", um);
		return "UomData";
	}

	// 4. Perform Delete Operation
	@RequestMapping("/delete")
	public String deleteUom(@RequestParam("id") Integer id, ModelMap map) {
		String message=null;
		try {
			if(service.isUomConnectedWithItem(id)) {
				message="Uom '"+id+"' Used in other Operations can't be deleted";
			}else {
				service.deleteUom(id);
				log.info(" UOM '" + id + "' deleted successfully");
				message=" UOM '" + id + "' deleted successfully";
			}
		}catch(HibernateOptimisticLockingFailureException e) {
			log.error("Uom unable to delete :"+id);
			message="UOM '" + id + "' Not found";
		}
		List<Uom> um = service.getAllUoms();
		map.addAttribute("message", message);
		map.addAttribute("list", um);
		return "UomData";

	}

	// 5. show edit page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id") Integer id, ModelMap map) {
		Uom um = service.getOneUomById(id);
		map.addAttribute("uom", um);
		return "UomEdit";
	}

	// 6.do Update Operation
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String doUpdateData(@ModelAttribute Uom uom, ModelMap map) {
		try {
		service.updateUom(uom);
		String msg = "Uom '" + uom.getId() + "' Update";
		List<Uom> um = service.getAllUoms();
		map.addAttribute("message", msg);
		map.addAttribute("list", um);
		}catch(Exception e) {
			log.error("Exception" +e.getMessage());
			map.addAttribute("message", "Problem in Operation");
		}
		return "UomData";
	}

	// 7.Excel Export
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		List<Uom> um = service.getAllUoms();
		ModelAndView m = new ModelAndView();
		m.setView(new UomExcelView());
		m.addObject("uom", um);
		return m;
	}

	// 8.PDf Export
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {

		List<Uom> um = service.getAllUoms();
		ModelAndView mav = new ModelAndView();

		mav.setView(new UomPdfView());
		mav.addObject("uom", um);
		return mav;

	}
}
