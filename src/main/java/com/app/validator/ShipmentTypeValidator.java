package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;

@Component
public class ShipmentTypeValidator implements Validator {
	@Autowired
	private IShipmentTypeService service;

	@Override
	public boolean supports(Class<?> clazz) {
		return ShipmentType.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ShipmentType st=(ShipmentType)target;
		
		if(st.getMode()==null|"".equals(st.getMode())) {
			errors.rejectValue("mode",null, "*");
		}
		
		if(!Pattern.compile("[A-Z0-9]{3,10}").matcher(st.getCode()).matches()) {
			errors.rejectValue("code", null, "Please Enter code [3-10] uppercase or Digits");	
		}
		else if(service.isShipmentCodeExist(st.getCode())) {
			errors.rejectValue("code", null,"code Already exist, Please choose other");
		}
		if(st.getEnable()==null|"".equals(st.getEnable())) {
			errors.rejectValue("enable",null, "*");
		}
		
		if(st.getGrade()==null|"".equals(st.getGrade())) {
			errors.rejectValue("grade",null, "*");
		}
				
		if(!Pattern.compile("[\\w\\.\\_\\+\\s]{1,200}").matcher(st.getDcpt()).matches()) {
			errors.rejectValue("dcpt", null, "Please Enter Description [1 to 200] words");	
		}
	
	}
	
}
