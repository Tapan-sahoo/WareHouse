package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUomDao;
import com.app.model.Item;
import com.app.model.Uom;

@Repository
public class UomDaoImpl implements IUomDao {

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveUom(Uom uom) {
		
		return (Integer) ht.save(uom);
	}

	@Override
	public void updateUom(Uom uom) {
		ht.update(uom);

	}

	@Override
	public void deleteUom(Integer id) {
		Uom uom=new Uom();
		uom.setId(id);
		ht.delete(uom);

	}

	@Override
	public Uom getOneUomById(Integer id) {
		
		return ht.get(Uom.class, id);
	}

	@Override
	public List<Uom> getAllUoms() {
		
		return ht.loadAll(Uom.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isUomModelExist(String model) {
		
		/*select count(*) from uomTab where model=?,
				if count=1(data not exist=false)
				else count=1(data exist=true)*/
	List<Long> rowsCount=(List<Long>) ht.findByCriteria(
		DetachedCriteria.forClass(Uom.class).setProjection(Projections.rowCount()).add(Restrictions.eq("model",model)));
		return rowsCount.get(0)!=0?true:false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean isUomConnectedWithItem(Integer id) {
		List<Long> rowsCount=(List<Long>) ht.findByCriteria(
				DetachedCriteria.forClass(Item.class).setProjection(Projections.rowCount()).add(Restrictions.eq("uom.id",id)));
				return rowsCount.get(0)!=0?true:false;
	}
	
	
	
}
