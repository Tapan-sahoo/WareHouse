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

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
import com.app.validator.ShipmentTypeValidator;
import com.app.view.ShipmentTypeExcelView;
import com.app.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/shipment")
public class ShipmentController {

	private static final Logger log=Logger.getLogger(ShipmentController.class);
	
	@Autowired
	private IShipmentTypeService service;
	
	@Autowired
	private ShipmentTypeValidator validator;

	// 1.Display Register Page
	@RequestMapping("/register")
	public String showRegPage(ModelMap map) {
		map.addAttribute("st", new ShipmentType());
		return "ShipmentRegister";

	}

	// 2.On click Submit Button
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String saveData(@ModelAttribute("st") ShipmentType st,Errors errors, ModelMap map) {
		log.info("Entered into Shipment Controller insert method");
		validator.validate(st, errors);
		log.info("Validations are completed");
		if(!errors.hasErrors()) {
			log.info("No Errors found in save");
		try {
		Integer id = service.saveShipmentType(st);
		log.debug("Shipment created with id:" +id);
		String msg = "ShipmentType '" + id + "' saved";
		map.addAttribute("message", msg);

		// clear form data
		map.addAttribute("st", new ShipmentType());
		}catch(Exception e) {
			log.error("Exception" +e.getMessage());
			map.addAttribute("message", "Problem in Operation");	
		}
		}
		return "ShipmentRegister";

	}

	// 3. getdata from db to UI
	@RequestMapping("/all")
	public String showData(ModelMap map) {
		List<ShipmentType> st = service.getAllShipmentTypes();
		map.addAttribute("list", st);
		return "ShipmentData";
	}

	// 4. Perform Delete Operation
	@RequestMapping("/delete")
	public String deleteShipmentType(@RequestParam("id") Integer id, ModelMap map) {
		String msg=null;
		try {
		service.deleteShipmentType(id);
		log.info("ShipmentType '" + id + "' Deleted Successful");
		 msg = "ShipmentType '" + id + "' Deleted Successful";
		}
		catch(HibernateOptimisticLockingFailureException e) {
			log.error("Shipment unable to delete :"+id);
			msg = "ShipmentType '" + id + "' Not Found";
		}
		
		List<ShipmentType> st = service.getAllShipmentTypes();
		map.addAttribute("message", msg);
		map.addAttribute("list", st);
		return "ShipmentData";

	}

	// 5. show edit page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id") Integer id, ModelMap map) {
		ShipmentType st = service.getOneShipmentTypeById(id);
		map.addAttribute("st", st);
		return "ShipmentEdit";
	}

	// 6.do Update Operation
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String doUpdateData(@ModelAttribute ShipmentType st, ModelMap map) {
		try {
		service.updateShipmentType(st);
		String msg = "Shipment '" + st.getId() + "' Update";
		List<ShipmentType> st1 = service.getAllShipmentTypes();
		map.addAttribute("message", msg);
		map.addAttribute("list", st1);
		}catch(Exception e) {
			log.error("Exception" +e.getMessage());
			map.addAttribute("message", "Problem in Operation");
		}
		return "ShipmentData";
	}

	// 7.Excel Export
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		List<ShipmentType> st = service.getAllShipmentTypes();
		ModelAndView m = new ModelAndView();
		m.setView(new ShipmentTypeExcelView());
		m.addObject("shipment", st);
		return m;
	}

	// 8.PDf Export
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {

		List<ShipmentType> st = service.getAllShipmentTypes();
		ModelAndView mav = new ModelAndView();

		mav.setView(new ShipmentTypePdfView());
		mav.addObject("shipment", st);
		return mav;

	}

}
