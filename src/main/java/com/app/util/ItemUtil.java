package com.app.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.app.model.OrderMethod;
import com.app.model.Uom;
import com.app.model.WhUserType;
import com.app.service.IOrderMethodService;
import com.app.service.IUomService;
import com.app.service.IWhUserTypeService;

@Component
public class ItemUtil {
	@Autowired
	private IUomService uomService;
	@Autowired
	private IOrderMethodService omService;
	@Autowired
	private IWhUserTypeService  whUserTypeService;

	public void addUiComponents(ModelMap map) {
		//UOM Input
		List<Uom> uoms=uomService.getAllUoms();
		map.addAttribute("uom", uoms);

		//Order method inputs
		List<OrderMethod> sales=omService.getOrderMethodByMode("Sale");
		map.addAttribute("sales", sales);

		List<OrderMethod> purchases=omService.getOrderMethodByMode("Purchase");
		map.addAttribute("purchase", purchases);

		//WhUserType inputs
		List<WhUserType> vendors=whUserTypeService.getWhUserByUserType("Vendor");
		map.addAttribute("vendor", vendors);
		List<WhUserType> customers=whUserTypeService.getWhUserByUserType("Customer");
		map.addAttribute("customer", customers);
	}
	
	
	
}
