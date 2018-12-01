package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IWhUserTypeDao;
import com.app.model.Item;
import com.app.model.WhUserType;

@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveWhUserType(WhUserType wu) {

		return (Integer) ht.save(wu);
	}

	@Override
	public void updateWhUserType(WhUserType wu) {
		ht.update(wu);

	}

	@Override
	public void deleteWhUserType(Integer id) {
		WhUserType wu = new WhUserType();
		wu.setId(id);
		ht.delete(wu);

	}

	@Override
	public WhUserType getOneWhUserTypeById(Integer id) {

		return ht.get(WhUserType.class, id);
	}

	@Override
	public List<WhUserType> getAllWhUserTypes() {

		return ht.loadAll(WhUserType.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WhUserType> getWhUserByUserType(String type) {
		List<WhUserType> wt = (List<WhUserType>)ht
				.findByCriteria(DetachedCriteria.forClass(WhUserType.class).add(Restrictions.eq("type",type)));
		return wt;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WhUserType> getWhUserByVenUserType(String userType) {
		List<WhUserType> wt = (List<WhUserType>) ht
				.findByCriteria(DetachedCriteria.forClass(WhUserType.class).add(Restrictions.eq("type",userType)));
		return wt;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean isWhUserCodeExist(String code) {
		List<Long> rowsCount=(List<Long>) ht.findByCriteria(
		DetachedCriteria.forClass(WhUserType.class).setProjection(Projections.rowCount()).add(Restrictions.eq("code", code)));
		return rowsCount.get(0)!=0?true:false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean isWhUserTypeConnectedWithItemVendor(Integer id) {
		List<Long> rowsCount=(List<Long>) ht.findByCriteria(
				DetachedCriteria.forClass(Item.class).setProjection(Projections.rowCount()).add(Restrictions.eq("whVendor.id", id)));
				return rowsCount.get(0)!=0?true:false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean isWhUserTypeConnectedWithItemCustomer(Integer id1) {
		List<Long> rowsCount=(List<Long>) ht.findByCriteria(
				DetachedCriteria.forClass(Item.class).setProjection(Projections.rowCount()).add(Restrictions.eq("whCustomer.id", id1)));
				return rowsCount.get(0)!=0?true:false;
	}
	

}
