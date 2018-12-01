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

import com.app.model.Customer;
import com.app.service.ICustomerService;
import com.app.validator.CustomerValidator;
import com.app.view.CustomerExcelView;
import com.app.view.CustomerPdfView;



@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService service;
	@Autowired
	private CustomerValidator validator;

	// 1.Display Register Page
	@RequestMapping("/register")
	public String showRegPage(ModelMap map) {
		map.addAttribute("cust", new Customer());
		return "CustomerRegister";

	}

	// 2.On click Submit Button
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String saveData(@ModelAttribute("cust") Customer cs,Errors errors, ModelMap map) {
		validator.validate(cs, errors);
		if(!errors.hasErrors()) {
		Integer custId = service.saveCustomer(cs);
		String msg = "Customer '" + custId + "' saved";
		map.addAttribute("message", msg);

		// clear form data
		map.addAttribute("cust", new Customer());
		}
		return "CustomerRegister";

	}

	// 3. getdata from db to UI
	@RequestMapping("/all")
	public String showData(ModelMap map) {
		List<Customer> cs = service.getAllCustomers();
		map.addAttribute("list", cs);
		return "CustomerData";
	}

	// 4. Perform Delete Operation
	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam("id") Integer custId, ModelMap map) {
		service.deleteCustomer(custId);;
		String msg = "Customer '" + custId + "' Deleted Successful";
		List<Customer> cs = service.getAllCustomers();
		map.addAttribute("message", msg);
		map.addAttribute("list", cs);
		return "CustomerData";

	}

	// 5. show edit page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id") Integer custId, ModelMap map) {
		Customer cs = service.getOneCustomerById(custId);
		map.addAttribute("cust", cs);
		return "CustomerEdit";
	}

	// 6.do Update Operation
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String doUpdateData(@ModelAttribute Customer cs, ModelMap map) {
		service.updateCustomer(cs);
		String msg = "Customer'" + cs.getCustId()+ "'Update";
		List<Customer> cs1 = service.getAllCustomers();
		map.addAttribute("message", msg);
		map.addAttribute("list",cs1);
		return "CustomerData";
	}

	// 7.Excel Export
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		List<Customer> cs = service.getAllCustomers();
		ModelAndView m = new ModelAndView();
		m.setView(new CustomerExcelView());
		m.addObject("customer", cs);
		return m;
	}

	// 8.PDf Export
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {

		List<Customer> cs= service.getAllCustomers();
		ModelAndView mav = new ModelAndView();

		mav.setView(new CustomerPdfView());
		mav.addObject("customer", cs);
		return mav;

	}
}
