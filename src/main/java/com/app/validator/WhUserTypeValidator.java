package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;

@Component
public class WhUserTypeValidator implements Validator {
	@Autowired
	private IWhUserTypeService service;

	@Override
	public boolean supports(Class<?> clazz) {
		return WhUserType.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		WhUserType wh = (WhUserType) target;

		if (wh.getType() == null || "".equals(wh.getType())) {
			errors.rejectValue("type", null, "Please choose one User Type");
		}

		if (!Pattern.compile("[A-Z0-9]{3,10}").matcher(wh.getCode()).matches()) {
			errors.rejectValue("code", null, "Please Enter code [3-10] uppercase or Digits");
		} else if (service.isWhUserCodeExist(wh.getCode())) {
			errors.rejectValue("code", null, "code Already exist, Please choose other");

		}

		if (!Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}").matcher(wh.getEmail()).matches()) {
			errors.rejectValue("email", null, "Please Enter email ends with @gmail.com");
		}

		if (!Pattern.compile("((\\+){1}91){1}[1-9]{1}[0-9]{9}").matcher(wh.getContact()).matches()) {
			errors.rejectValue("contact", null, "Please Enter contact");
		}

		if ("".equals(wh.getIdType())) {
			errors.rejectValue("idType", null, "Please choose one User Id Type");
		} else if ("OTHER".equals(wh.getIdType()) && "".equals(wh.getIfOther())) {
			errors.rejectValue("ifOther", null, "Please Enter Other Type");
		}

		/*
		 * if (!Pattern.compile("[0-9]{12}").matcher(wh.getIdNum()).matches()) {
		 * errors.rejectValue("idNum", null, "Please Enter 12 digit Number"); }
		 */

		if ("".equals(wh.getIdNum().trim())) {
			errors.rejectValue("idNum", null, "plz Enter id number");
		}

	}

}
