package com.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Vendor;

@Component
public class VendorValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Vendor.class.equals(clazz);
	}

	
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void validate(Object target, Errors errors) {
		Vendor vd = (Vendor) target;

		if ("".equals(vd.getVenName().trim())) {
			errors.rejectValue("venName", null, "*");
		}

		if (vd.getVenCode() == null | "".equals(vd.getVenCode())) {
			errors.rejectValue("venCode", null, "*");
		}
		if (vd.getVenDesg() == null | "".equals(vd.getVenDesg())) {
			errors.rejectValue("venDesg", null, "*");
		}
		if (vd.getVenPreserve()==null||"".equals(vd.getVenPreserve())) {
			errors.rejectValue("venPreserve", null, "*");
		}

	}

}
