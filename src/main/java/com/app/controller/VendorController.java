package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Vendor;
import com.app.service.IVendorService;
import com.app.validator.VendorValidator;
import com.app.view.VendorExcelView;
import com.app.view.VendorPdfView;
@Controller
@RequestMapping("/vendor")
public class VendorController {

	@Autowired
	private IVendorService service;
	
	@Autowired
	private VendorValidator validator;

	// 1.Display Register Page
	@RequestMapping("/register")
	public String showRegPage(ModelMap map) {
		map.addAttribute("vd", new Vendor());
		return "VendorRegister";

	}

	// 2.On click Submit Button
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String saveData(@ModelAttribute("vd") Vendor vd,Errors errors, ModelMap map) {
		validator.validate(vd, errors);
		if(!errors.hasErrors()) {
		Integer venId= service.saveVendor(vd);
		String msg = "Vendor  '" + venId + "' saved";
		map.addAttribute("message", msg);

		// clear form data
		map.addAttribute("vd", new Vendor());
		}
		return "VendorRegister";

	}

	// 3. getdata from db to UI
	@RequestMapping("/all")
	public String showData(ModelMap map) {
		List<Vendor> vd = service.getAllVendors();
		map.addAttribute("list", vd);
		return "VendorData";
	}

	// 4. Perform Delete Operation
	@RequestMapping("/delete")
	public String deleteVendor(@RequestParam("id") Integer venId, ModelMap map) {
		service.deleteVendor(venId);
		String msg = "Vendor '" + venId + "' Deleted Successful";
		List<Vendor> vd = service.getAllVendors();
		map.addAttribute("message", msg);
		map.addAttribute("list", vd);
		return "VendorData";

	}

	// 5. show edit page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id") Integer venId, ModelMap map) {
		Vendor vd = service.getOneVendorById(venId);
		map.addAttribute("vendor", vd);
		return "VendorEdit";
	}

	// 6.do Update Operation
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String doUpdateData(@ModelAttribute Vendor vd, ModelMap map) {
		service.updateVendor(vd);
		String msg = "Vendor'" + vd.getVenId() + "'Update";
		List<Vendor> vd1 = service.getAllVendors();
		map.addAttribute("message", msg);
		map.addAttribute("list", vd1);
		return "VendorData";
	}
	
	// 7.Excel Export
		@RequestMapping("/excel")
		public ModelAndView showExcel() {
			List<Vendor> vd = service.getAllVendors();
			ModelAndView m = new ModelAndView();
			m.setView(new VendorExcelView());
			m.addObject("vendor", vd);
			return m;
		}

		// 8.PDf Export
		@RequestMapping("/pdf")
		public ModelAndView showPdf() {

			List<Vendor> vd= service.getAllVendors();
			ModelAndView mav = new ModelAndView();

			mav.setView(new VendorPdfView());
			mav.addObject("vendor", vd);
			return mav;

		}
}
