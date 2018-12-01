package com.app.service;

import java.util.List;

import com.app.model.OrderMethod;


public interface IOrderMethodService {
	
	public Integer saveOrderMethod(OrderMethod om);
	public void updateOrderMethod(OrderMethod om);
	public void deleteOrderMethod(Integer id);
	public OrderMethod getOneOrderMethodById(Integer id);
	public List<OrderMethod> getAllOrderMethods();
	public List<OrderMethod> getOrderMethodByMode(String mode);
	public boolean isOrderCodeExist(String code);
	public boolean isOrderMethodConnectedWithItemSale(Integer id);
	public boolean isOrderMethodConnectedWithItemPurchase(Integer id1);
}
