package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@Component
public class OrderMethodValidator implements Validator {
	@Autowired
	private IOrderMethodService service;

	@Override
	public boolean supports(Class<?> clazz) {
		return OrderMethod.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		OrderMethod om = (OrderMethod) target;

		if (om.getMode() == null | "".equals(om.getMode())) {
			errors.rejectValue("mode", null, "Please choose one mode");
		}

		if (!Pattern.compile("[A-Z0-9]{3,10}").matcher(om.getCode()).matches()) {
			errors.rejectValue("code", null, "Please Enter code [3-10] uppercase or Digits");
		}
		else if(service.isOrderCodeExist(om.getCode())) {
			errors.rejectValue("code", null,"code Already exist, Please choose other");
			
		}

		if ("".equals(om.getMethod())) {
			errors.rejectValue("method", null, "Please choose atlist one method");
		}

		if (om.getAccept() == null || (om.getAccept().isEmpty())) {
			errors.rejectValue("accept", null, "Please choose one OrderAccept Type");
		}

		if (!Pattern.compile("[\\w\\.\\_\\+\\s]{1,200}").matcher(om.getDcpt()).matches()) {
			errors.rejectValue("dcpt", null, "Please Enter Description [1 to 200] words");
		}
	}

}
