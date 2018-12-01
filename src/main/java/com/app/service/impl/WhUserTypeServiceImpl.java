package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;

@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {
	@Autowired
	private IWhUserTypeDao dao;

	@Transactional
	public Integer saveWhUserType(WhUserType wu) {

		return dao.saveWhUserType(wu);
	}

	@Transactional
	public void updateWhUserType(WhUserType wu) {
		dao.updateWhUserType(wu);

	}

	@Transactional
	public void deleteWhUserType(Integer id) {
		dao.deleteWhUserType(id);

	}

	@Transactional(readOnly = true)
	public WhUserType getOneWhUserTypeById(Integer id) {

		return dao.getOneWhUserTypeById(id);
	}

	@Transactional(readOnly = true)
	public List<WhUserType> getAllWhUserTypes() {

		return dao.getAllWhUserTypes();
	}

	@Transactional(readOnly = true)
	public List<WhUserType> getWhUserByUserType(String type) {	
		return dao.getWhUserByUserType(type);
	}
	
	@Transactional(readOnly = true)
	public List<WhUserType> getWhUserByVenUserType(String userType) {	
		return dao.getWhUserByVenUserType(userType);
	}

	@Transactional(readOnly = true)
	public boolean isWhUserCodeExist(String code) {
		return dao.isWhUserCodeExist(code);
	}
	
	@Transactional(readOnly = true)
	public boolean isWhUserTypeConnectedWithItemVendor(Integer id) {
		return dao.isWhUserTypeConnectedWithItemVendor(id);
	}
	
	@Transactional(readOnly = true)
	public boolean isWhUserTypeConnectedWithItemCustomer(Integer id1) {
		return dao.isWhUserTypeConnectedWithItemCustomer(id1);
	}
}
