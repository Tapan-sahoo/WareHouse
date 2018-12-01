package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;
import com.app.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerDao dao;

	@Transactional
	public Integer saveCustomer(Customer cs) {

		return dao.saveCustomer(cs);
	}

	@Transactional
	public void updateCustomer(Customer cs) {
		dao.updateCustomer(cs);

	}

	@Transactional
	public void deleteCustomer(Integer custId) {
		dao.deleteCustomer(custId);

	}

	@Transactional(readOnly = true)
	public Customer getOneCustomerById(Integer custId) {
		return dao.getOneCustomerById(custId);
	}

	@Transactional(readOnly = true)
	public List<Customer> getAllCustomers() {
		return dao.getAllCustomers();
	}

}
