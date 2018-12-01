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

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
import com.app.validator.WhUserTypeValidator;
import com.app.view.WhUserTypeExcelView;
import com.app.view.WhUserTypePdfView;

@Controller
@RequestMapping("/user")
public class WhUserController {

	private static final Logger log=Logger.getLogger(WhUserController.class);
	@Autowired
	private IWhUserTypeService service;
	@Autowired
	private WhUserTypeValidator validator;

	// 1.Display Register Page
	@RequestMapping("/register")
	public String showRegPage(ModelMap map) {
		map.addAttribute("wu", new WhUserType());
		return "WhUserRegister";

	}

	// 2.On click Submit Button
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String saveData(@ModelAttribute("wu") WhUserType wu, Errors errors, ModelMap map) {
		log.info("Entered into WhUSer Controller insert method");
		validator.validate(wu, errors);
		log.info("Validations are completed");
		if(!errors.hasErrors()) {
			log.info("No Errors found in save");
			try {
		Integer id = service.saveWhUserType(wu);
		log.debug("WhUserType created with id:" +id);
		String msg = "WhUser '" + id + "' saved";
		map.addAttribute("message", msg);

		// clear form data
		map.addAttribute("wu", new WhUserType());
		}
			catch(Exception e) {
				log.error("Exception" +e.getMessage());
				map.addAttribute("message", "Problem in Operation");	
			}
			}
		return "WhUserRegister";

	}

	// 3. getdata from db to UI
	@RequestMapping("/all")
	public String showData(ModelMap map) {
		List<WhUserType> wu = service.getAllWhUserTypes();
		map.addAttribute("list", wu);
		return "WhUserData";
	}

	// 4. Perform Delete Operation
	@RequestMapping("/delete")
	public String deleteUom(@RequestParam("id") Integer id, ModelMap map) {
		String msg=null;
		
			try{
				if(service.isWhUserTypeConnectedWithItemVendor(id))  {
					msg="WhUserType can't deleted";
				}
				else if(service.isWhUserTypeConnectedWithItemCustomer(id)) {
					msg="WhUserType can't deleted";
				}
				
				else {
					service.deleteWhUserType(id);
					log.info(" WhUserType '" + id + "' Deleted Successful");
					msg=" WhUserType '" + id + "' Deleted Successful";
				}
			}catch(HibernateOptimisticLockingFailureException e) {
				log.error("WhUserType unable to delete :"+id);	
				msg=" WhUserType '" + id + "' Not Found";
			}
		//service.deleteWhUserType(id);
		List<WhUserType> wu = service.getAllWhUserTypes();
		map.addAttribute("message", msg);
		map.addAttribute("list", wu);
		return "WhUserData";

	}

	// 5. show edit page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id") Integer id, ModelMap map) {
		WhUserType wu = service.getOneWhUserTypeById(id);
		map.addAttribute("wu", wu);
		return "WhUserEdit";
	}

	// 6.do Update Operation
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String doUpdateData(@ModelAttribute WhUserType wu, ModelMap map) {
		try {
		service.updateWhUserType(wu);
		String msg = "WhUser '" + wu.getId() + "' Update";
		List<WhUserType> wu1 = service.getAllWhUserTypes();
		map.addAttribute("message", msg);
		map.addAttribute("list", wu1);
		}catch(Exception e){
			log.error("Exception" +e.getMessage());
			map.addAttribute("message", "Problem in Operation");
		}
		return "WhUserData";
	}

	// 7.Excel Export
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		List<WhUserType> wu = service.getAllWhUserTypes();
		ModelAndView m = new ModelAndView();
		m.setView(new WhUserTypeExcelView());
		m.addObject("user", wu);
		return m;
	}

	// 8.PDf Export
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {

		List<WhUserType> wu= service.getAllWhUserTypes();
		ModelAndView mav = new ModelAndView();

		mav.setView(new WhUserTypePdfView());
		mav.addObject("user", wu);
		return mav;

	}
}
