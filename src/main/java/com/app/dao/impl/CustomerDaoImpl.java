package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;

@Repository
public class CustomerDaoImpl implements ICustomerDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveCustomer(Customer cs) {

		return (Integer) ht.save(cs);
	}

	@Override
	public void updateCustomer(Customer cs) {
		ht.update(cs);

	}

	@Override
	public void deleteCustomer(Integer custId) {
		Customer cs = new Customer();
		cs.setCustId(custId);
		ht.delete(cs);

	}

	@Override
	public Customer getOneCustomerById(Integer custId) {
		return ht.get(Customer.class, custId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return ht.loadAll(Customer.class);
	}

}
