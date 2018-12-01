package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;

@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveShipmentType(ShipmentType st) {
		
		 return (Integer) ht.save(st);
	}

	@Override
	public void updateShipmentType(ShipmentType st) {
		ht.update(st);
		
	}

	@Override
	public void deleteShipmentType(Integer id) {
		ShipmentType st=new ShipmentType();
		st.setId(id);
		ht.delete(st);
		
	}

	@Override
	public ShipmentType getOneShipmentTypeById(Integer id) {
		return ht.get(ShipmentType.class, id);
	}

	@Override
	public List<ShipmentType> getAllShipmentTypes() {
		return ht.loadAll(ShipmentType.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShipmentType> getShipmentTypeByCode(String code) {	
		List<ShipmentType> st=(List<ShipmentType>) ht.findByCriteria(DetachedCriteria.forClass(ShipmentType.class).add(Restrictions.eq("enable", code)));
		return st;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean isShipmentCodeExist(String code) {
		List<Long> rowsCount=(List<Long>) ht.findByCriteria(
		DetachedCriteria.forClass(ShipmentType.class).setProjection(Projections.rowCount()).add(Restrictions.eq("code", code)));
		return rowsCount.get(0)!=0?true:false;
	}

}
