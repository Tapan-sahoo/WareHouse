package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.PurchaseOrder;
import com.app.model.ShipmentType;
import com.app.model.WhUserType;
import com.app.service.IPurchaseOrderService;
import com.app.service.IShipmentTypeService;
import com.app.service.IWhUserTypeService;


@Controller
@RequestMapping("/purchase")
public class PurchaseOrderController {

	@Autowired
	private IPurchaseOrderService service;
	@Autowired
	private IWhUserTypeService userservice;
	@Autowired
	private IShipmentTypeService shipmentService;
	
	// 1.Display Register Page
	@RequestMapping("/register")
	public String showRegPage(ModelMap map) {
		List<WhUserType> vendor1=userservice.getWhUserByVenUserType("Vendor");
		map.addAttribute("vendor1",vendor1);
		List<ShipmentType> shipment=shipmentService.getShipmentTypeByCode("YES");
		map.addAttribute("shipment",shipment);
		map.addAttribute("porder", new PurchaseOrder());
		return "PurchaseOrderRegister";

	}

	// 2.On click Submit Button
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String saveData(@ModelAttribute PurchaseOrder porder, ModelMap map) {
		
		
		Integer id = service.savePurchaseOrder(porder);
		String msg = "PurchaseOrder  '" + id + "' saved";
		List<WhUserType> vendor1=userservice.getWhUserByVenUserType("Vendor");
		map.addAttribute("vendor1",vendor1);
		List<ShipmentType> shipment=shipmentService.getShipmentTypeByCode("YES");
		map.addAttribute("shipment",shipment);
		map.addAttribute("message", msg);

		// clear form data
		
		map.addAttribute("porder", new PurchaseOrder());
		
		return "PurchaseOrderRegister";

	}

	// 3. getdata from db to UI
	@RequestMapping("/all")
	public String showData(ModelMap map) {
		List<PurchaseOrder> po = service.getAllPurchaseOrders();
		map.addAttribute("list", po);
		return "PurchaseOrderData";
	}

	// 4. Perform Delete Operation
	@RequestMapping("/delete")
	public String deletePurchaseOrder(@RequestParam("id") Integer id, ModelMap map) {
		service.deletePurchaseOrder(id);
		String msg = "PurchaseOrder '" + id + "' Deleted Successful";
		List<PurchaseOrder> po = service.getAllPurchaseOrders();
		map.addAttribute("message", msg);
		map.addAttribute("list", po);
		return "PurchaseOrderData";

	}

	// 5. show edit page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id")Integer id, ModelMap map) {
		PurchaseOrder po = service.getOnePurchaseOrderById(id);
		List<WhUserType> vendor=userservice.getWhUserByVenUserType("Vendor");
		map.addAttribute("vendor1",vendor);
		List<ShipmentType> shipment=shipmentService.getShipmentTypeByCode("YES");
		map.addAttribute("shipment",shipment);
		map.addAttribute("porder", po);
		return "PurchaseOrderEdit";
	}

	// 6.do Update Operation
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String doUpdateData(@ModelAttribute PurchaseOrder po, ModelMap map) {
		service.updatePurchaseOrder(po);
		String msg = "PurchaseOrder'" + po.getId() + "'Update";
		List<PurchaseOrder> po1 = service.getAllPurchaseOrders();
		map.addAttribute("message", msg);
		map.addAttribute("list", po1);
		return "PurchaseOrderData";
	}

	/*// 7.Excel Export
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

	}*/
}
