package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@Service
public class OrderMethodServiceImpl implements IOrderMethodService {
	@Autowired
	private IOrderMethodDao dao;

	@Transactional
	public Integer saveOrderMethod(OrderMethod om) {

		return dao.saveOrderMethod(om);
	}

	@Transactional
	public void updateOrderMethod(OrderMethod om) {
		dao.updateOrderMethod(om);

	}

	@Transactional
	public void deleteOrderMethod(Integer id) {
		dao.deleteOrderMethod(id);

	}

	@Transactional(readOnly = true)
	public OrderMethod getOneOrderMethodById(Integer id) {

		return dao.getOneOrderMethodById(id);
	}

	@Transactional(readOnly = true)
	public List<OrderMethod> getAllOrderMethods() {

		return dao.getAllOrderMethods();
	}

	@Transactional(readOnly=true)
	public List<OrderMethod> getOrderMethodByMode(String mode) {
		return dao.getOrderMethodByMode(mode);
	}
	@Override
	public boolean isOrderCodeExist(String code) {
		return dao.isOrderCodeExist(code);
	}
	
	@Override
	public boolean isOrderMethodConnectedWithItemSale(Integer id) {
		return dao.isOrderMethodConnectedWithItemSale(id);
	}
	
	@Override
	public boolean isOrderMethodConnectedWithItemPurchase(Integer id1) {
		return dao.isOrderMethodConnectedWithItemPurchase(id1);
	}
}
