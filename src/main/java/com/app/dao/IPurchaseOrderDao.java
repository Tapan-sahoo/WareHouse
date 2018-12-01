package com.app.dao;

import java.util.List;

import com.app.model.PurchaseOrder;

public interface IPurchaseOrderDao {
	
	public Integer savePurchaseOrder(PurchaseOrder po);
	public void updatePurchaseOrder(PurchaseOrder po);
	public void deletePurchaseOrder(Integer id);
	public PurchaseOrder getOnePurchaseOrderById(Integer id);
	public List<PurchaseOrder> getAllPurchaseOrders();
	
}
