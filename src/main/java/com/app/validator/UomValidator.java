package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Uom;
import com.app.service.IUomService;

@Component
public class UomValidator implements Validator {
	@Autowired
	public IUomService service;

	@Override
	public boolean supports(Class<?> clazz) {
		return Uom.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// downcast to model class type
		Uom uom = (Uom) target;
		if ("".equals(uom.getType())) {
			errors.rejectValue("type", null, "Please choose one Type");
		}

		if (!Pattern.compile("[A-Z]{4,10}").matcher(uom.getModel()).matches()) {
			errors.rejectValue("model", null, "Please Enter valid model [4 to 10] uppercase only");
		}
		else if(service.isUomModelExist(uom.getModel())){
				errors.rejectValue("model", null,"uom Model Alredy exist, Please Choose other");
			}
		

		if (!Pattern.compile("[A-Za-z0-9\\.\\_||+\\s]{1,200}").matcher(uom.getDcpt()).matches()) {
			errors.rejectValue("dcpt", null, "Please Enter Description [1 to 200] words");
		}

	}

}
