package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPurchaseOrderDao;
import com.app.model.PurchaseOrder;
import com.app.service.IPurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {
	@Autowired
	private IPurchaseOrderDao dao;

	@Transactional
	public Integer savePurchaseOrder(PurchaseOrder po) {

		return dao.savePurchaseOrder(po);
	}

	@Transactional
	public void updatePurchaseOrder(PurchaseOrder po) {
		dao.updatePurchaseOrder(po);
	}

	@Transactional
	public void deletePurchaseOrder(Integer id) {
		dao.deletePurchaseOrder(id);
	}
	@Transactional(readOnly=true)
	public PurchaseOrder getOnePurchaseOrderById(Integer id) {
		return dao.getOnePurchaseOrderById(id);
	}

	@Transactional(readOnly=true)
	public List<PurchaseOrder> getAllPurchaseOrders() {
		return dao.getAllPurchaseOrders();
	}

}
