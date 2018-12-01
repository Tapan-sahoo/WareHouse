package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Item;


@Component
public class ItemValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Item.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Item item= (Item) target;

		
		if(!Pattern.compile("[A-Z]{4,8}").matcher(item.getItemCode()).matches()) {
			errors.rejectValue("itemCode", null, "Enter Code [4-8] uppercase");
		}
		
		if(item.getLength()<=0 || item.getWidth()<=0 || item.getHeight()<=0) {
			errors.rejectValue("length", null, "Enter Valid dimensions");
		}
		
		if (item.getBaseCost()<=0) {
			errors.rejectValue("baseCost", null, "Enter Valid Base Cost");
		}

		if ("".equals(item.getBaseCurrency())) {
			errors.rejectValue("baseCurrency", null, "Please choose Currency");
		}

		if (item.getUom()==null || item.getUom().getId() == null) {
			errors.rejectValue("uom", null, "Please choose one Uom");
		}

		if (item.getOmSale() ==null || item.getOmSale().getId()==null) {
			errors.rejectValue("omSale", null, "Please choose one Sale Type");
		}

		if (item.getOmPurchase()==null||item.getOmPurchase().getId()==null) {
			errors.rejectValue("omPurchase", null, "Please choose one Purchase Type");
		}

		if(item.getWhVendor() == null || item.getWhVendor().isEmpty()) {
			errors.rejectValue("whVendor", null, "Please choose atleast one Vendor");
		}

		if (item.getWhCustomer() ==null || item.getWhCustomer().isEmpty()) {
			errors.rejectValue("whCustomer", null, "Please choose one Customer");
		}
		if ("".equals(item.getDcpt().trim())) {
			errors.rejectValue("dcpt", null, "Please enter Description");
		}

	}

}
