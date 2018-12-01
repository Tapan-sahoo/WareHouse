package com.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Customer;

@Component
public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Customer.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Customer cust = (Customer) target;

		if ("".equals(cust.getCustCode().trim())) {
			errors.rejectValue("custCode", null, "*");
		}

		if ("".equals(cust.getCustAddr().trim())) {
			errors.rejectValue("custAddr", null, "*");
		}

		if (cust.getCustLocs() == null | "".equals(cust.getCustLocs())) {
			errors.rejectValue("custLocs", null, "*");
		}

		if (cust.getCustEnabled() == null | "".equals(cust.getCustEnabled())) {
			errors.rejectValue("custEnabled", null, "*");
		}

		if ("".equals(cust.getCustEmail())) {
			errors.rejectValue("custEmail", null, "*");
		}

		if ("".equals(cust.getCustContact())) {
			errors.rejectValue("custContact", null, "*");
		}

	}

}
