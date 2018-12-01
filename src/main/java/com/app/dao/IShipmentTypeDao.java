package com.app.dao;

import java.util.List;

import com.app.model.ShipmentType;

public interface IShipmentTypeDao {
	
	public Integer saveShipmentType(ShipmentType st);
	public void updateShipmentType(ShipmentType st);
	public void deleteShipmentType(Integer id);
	public ShipmentType getOneShipmentTypeById(Integer id);
	public List<ShipmentType> getAllShipmentTypes();
	public List<ShipmentType> getShipmentTypeByCode(String code);
	public boolean isShipmentCodeExist(String code);
}
