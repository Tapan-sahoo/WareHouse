package com.app.dao;

import java.util.List;

import com.app.model.Customer;


public interface ICustomerDao {
	
	public Integer saveCustomer(Customer cs);
	public void updateCustomer(Customer cs);
	public void deleteCustomer(Integer custId);
	public Customer getOneCustomerById(Integer custId);
	public List<Customer> getAllCustomers();

}
