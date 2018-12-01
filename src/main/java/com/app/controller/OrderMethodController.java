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

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
import com.app.validator.OrderMethodValidator;
import com.app.view.OrderMethodExcelView;
import com.app.view.OrderMethodPdfView;

@Controller
@RequestMapping("/ordermethod")

public class OrderMethodController {
	
	private static final Logger log=Logger.getLogger(OrderMethodController.class);
	
	@Autowired
	private IOrderMethodService service;
	@Autowired
	private OrderMethodValidator validator;

	
	// 1.Display Register Page
	@RequestMapping("/register")
	public String showRegPage(ModelMap map) {
		map.addAttribute("om", new OrderMethod());
		return "OrderMethodRegister";
	}

	// 2.On click Submit Button
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String showData(@ModelAttribute("om") OrderMethod om,Errors errors, ModelMap map) {
		log.info("Entered into OrderMethod Controller insert method");
		validator.validate(om, errors);
		log.info("Validations are completed");
		if(!errors.hasErrors()) {
			
			log.info("No Errors found in save");
			try {
			Integer id = service.saveOrderMethod(om);
			log.debug("OrderMethod created with id:" +id);
			String msg = "OrderMethod '" + id + "' saved";
			map.addAttribute("message", msg);

			// clear form data
			map.addAttribute("om", new OrderMethod());
			}catch(Exception e) {
				log.error("Exception" +e.getMessage());
				map.addAttribute("message", "Problem in Operation");	
			}
		}
		return "OrderMethodRegister";

	}

	// 3. getdata from db to UI
	@RequestMapping("/all")
	public String showData(ModelMap map) {
		List<OrderMethod> om = service.getAllOrderMethods();
		map.addAttribute("list", om);
		return "OrderMethodData";
	}

	//4. Perform Delete Operation
	@RequestMapping("/delete")
	public String deleteOrderMethod(@RequestParam("id") Integer id, ModelMap map) {
		String msg=null;
		try{
			if(service.isOrderMethodConnectedWithItemSale(id)) {
				msg="OrderMethod can't deleted";
			}
			else if(service.isOrderMethodConnectedWithItemPurchase(id)) {
				msg="OrderMethod can't deleted";
			}
			
			else {
				service.deleteOrderMethod(id);
				log.info(" OrderMethod '" + id + "' Deleted Successful");
				msg=" OrderMethod '" + id + "' Deleted Successful";
			}
		}catch(HibernateOptimisticLockingFailureException e) {
			log.error("OrderMethod unable to delete :"+id);
			msg=" OrderMethod '" + id + "' Not Found";
		}
		
		
		//String msg = " OrderMethod'" + id + "' Deleted Successful";
		List<OrderMethod> om = service.getAllOrderMethods();
		map.addAttribute("message", msg);
		map.addAttribute("list", om);
		return "OrderMethodData";

	}

	// 5. show edit page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id") Integer id, ModelMap map) {
		OrderMethod om = service.getOneOrderMethodById(id);
		map.addAttribute("om", om);
		return "OrderMethodEdit";
	}

	// 6.do Update Operation
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String doUpdateData(@ModelAttribute OrderMethod om, ModelMap map) {
		try {
		service.updateOrderMethod(om);
		String msg = "OrderMethod '" + om.getId() + "' Update";
		List<OrderMethod> om1 = service.getAllOrderMethods();
		map.addAttribute("message", msg);
		map.addAttribute("list", om1);
		}catch(Exception e) {
			log.error("Exception" +e.getMessage());
			map.addAttribute("message", "Problem in Operation");
		}
		return "OrderMethodData";
	}
	//7.Excel Export
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		List<OrderMethod> om = service.getAllOrderMethods();
		ModelAndView m = new ModelAndView();
		m.setView(new OrderMethodExcelView());
		m.addObject("order", om);
		return m;
	}

	// 8.PDf Export
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {

		List<OrderMethod> om = service.getAllOrderMethods();
		ModelAndView mav = new ModelAndView();

		mav.setView(new OrderMethodPdfView());
		mav.addObject("order",om);
		return mav;

	}


}
