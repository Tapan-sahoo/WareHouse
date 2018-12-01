package com.app.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Item;
import com.app.service.IItemService;

import com.app.util.ItemUtil;
import com.app.validator.ItemValidator;
import com.app.view.ItemExcelView;
import com.app.view.ItemPdfView;

@Controller
@RequestMapping("/item")
public class ItemController {
	private static final Logger log=Logger.getLogger(ItemController.class);
	@Autowired
	private IItemService service;

	@Autowired
	private ItemValidator validator;
	@Autowired
	private ItemUtil util;


	// 1.Display Register Page
	@RequestMapping("/register")
	public String showRegPage(ModelMap map) {
		map.addAttribute("item", new Item());
		/*List<Uom> uom = uomservice.getAllUoms();
		map.addAttribute("uom", uom);
		//order method
		List<OrderMethod> sales= omservice.getOrderMethodByMode("Sale");
		map.addAttribute("sales",sales);
		List<OrderMethod> purchase= omservice.getOrderMethodByMode("Purchase");
		map.addAttribute("purchase",purchase);

		//WhUserType 
		List<WhUserType> vendor= whusertype.getWhUserByUserType("Vendor");
		map.addAttribute("vendor",vendor);
		List<WhUserType> customer= whusertype.getWhUserByUserType("Customer");
		map.addAttribute("customer",customer);*/
		util.addUiComponents(map);
		return "ItemRegister";

	}

	// 2.On click Submit Button
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String saveData(@ModelAttribute("item") Item item,Errors errors, ModelMap map) {
		log.info("Entered into Item Controller insert method");
		validator.validate(item, errors);
		log.info("Validations are completed");
		if(!errors.hasErrors()) {
			log.info("No Errors found in save");
			try {
				Integer id = service.saveItem(item);
				log.debug("WhUserType created with id:" +id);
				String msg = "Item '" + item.getItemId() + "' saved";
				map.addAttribute("message", msg);
				/*List<Uom> uom = uomservice.getAllUoms();
		map.addAttribute("uom", uom);
		//order method
		List<OrderMethod> sales= omservice.getOrderMethodByMode("Sale");
		map.addAttribute("sales",sales);

		List<OrderMethod> purchase= omservice.getOrderMethodByMode("Purchase");
		map.addAttribute("purchase",purchase);

		//WhUser
		List<WhUserType> vendor= whusertype.getWhUserByUserType("Vendor");
		map.addAttribute("vendor",vendor);
		List<WhUserType> customer= whusertype.getWhUserByUserType("Customer");
		map.addAttribute("customer",customer);
				 */
				// clear form data
				map.addAttribute("item", new Item());
			}catch(Exception e) {
				log.error("Exception" +e.getMessage());
				map.addAttribute("message", "Problem in Operation");	
			}
		}
		util.addUiComponents(map);
		return "ItemRegister";

	}

	// 3. getdata from db to UI
	@RequestMapping("/all")
	public String showData(ModelMap map) {
		List<Item> item = service.getAllItems();
		map.addAttribute("list", item);
		return "ItemData";
	}

	// 4. Perform Delete Operation
	@RequestMapping("/delete")
	public String deleteItem(@RequestParam("id") Integer itemId, ModelMap map) {
		try {
			service.deleteItem(itemId);
			log.info("Item '" + itemId + "' Deleted Successful");
			String msg = "Item '" + itemId + "' Deleted Successful";
			List<Item> item = service.getAllItems();
			map.addAttribute("message", msg);
			map.addAttribute("list", item);
		}catch(Exception e){
			log.error("Exception" +e.getMessage());
		}
		return "ItemData";

	}

	// 5. show edit page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id") Integer itemId, ModelMap map) {
		Item item = service.getOneItemById(itemId);
		map.addAttribute("item", item);
		/*List<Uom> uom = uomservice.getAllUoms();
		map.addAttribute("uom", uom);
		//order method
		List<OrderMethod> sales= omservice.getOrderMethodByMode("Sale");
		map.addAttribute("sales",sales);

		List<OrderMethod> purchase= omservice.getOrderMethodByMode("Purchase");
		map.addAttribute("purchase",purchase);

		//WhUser
		List<WhUserType> vendor= whusertype.getWhUserByUserType("Vendor");
		map.addAttribute("vendor",vendor);
		List<WhUserType> customer= whusertype.getWhUserByUserType("Customer");
		map.addAttribute("customer",customer);
		 */
		util.addUiComponents(map);
		return "ItemEdit";
	}

	// 6.do Update Operation
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String doUpdateData(@ModelAttribute Item item,Errors errors, ModelMap map) {
		validator.validate(item, errors);
		if(!errors.hasErrors()) {
			try{
				service.updateItem(item);

				String msg = "Item '" + item.getItemId() + "' Update";
				List<Item> item1 = service.getAllItems();
				map.addAttribute("message", msg);
				map.addAttribute("list", item1);
			}catch(Exception e) {
				log.error("Exception" +e.getMessage());
				map.addAttribute("message", "Problem in Operation");
			}
		}
		return "ItemData";
	}

	// 7.Excel Export
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		List<Item> item = service.getAllItems();
		ModelAndView m = new ModelAndView();
		m.setView(new ItemExcelView());
		m.addObject("item", item);
		return m;
	}

	// 8.PDf Export
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {

		List<Item> item = service.getAllItems();
		ModelAndView mav = new ModelAndView();

		mav.setView(new ItemPdfView());
		mav.addObject("item", item);
		return mav;

	}
}
