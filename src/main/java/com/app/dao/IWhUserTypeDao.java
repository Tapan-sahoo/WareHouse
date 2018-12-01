package com.app.dao;

import java.util.List;


import com.app.model.WhUserType;

public interface IWhUserTypeDao {
	
	public Integer saveWhUserType(WhUserType wu);
	public void updateWhUserType(WhUserType wu);
	public void deleteWhUserType(Integer id);
	public WhUserType getOneWhUserTypeById(Integer id);
	public List<WhUserType> getAllWhUserTypes();
	public List<WhUserType> getWhUserByUserType(String type);
	public List<WhUserType> getWhUserByVenUserType(String userType);
	public boolean isWhUserCodeExist(String code);
	public boolean isWhUserTypeConnectedWithItemVendor(Integer id);
	public boolean isWhUserTypeConnectedWithItemCustomer(Integer id1);
}
