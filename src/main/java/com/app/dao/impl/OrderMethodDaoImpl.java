package com.app.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderMethodDao;
import com.app.model.Item;
import com.app.model.OrderMethod;

@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {
	
	private static final Logger log=Logger.getLogger(OrderMethodDaoImpl.class);
	
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveOrderMethod(OrderMethod om) {
		log.info("Ordermethod saved");
		return (Integer) ht.save(om);
	}

	@Override
	public void updateOrderMethod(OrderMethod om) {
		
		ht.update(om);
		log.info("Ordermethod updated");
	}

	@Override
	public void deleteOrderMethod(Integer id) { 
		OrderMethod om=new OrderMethod();
		om.setId(id);
		
		ht.delete(om);
		log.info("Ordermethod deleted ");

	}

	@Override
	public OrderMethod getOneOrderMethodById(Integer id) {
		log.info("getOneOrdermethodById ");
		return ht.get(OrderMethod.class, id);
		
	}

	@Override
	public List<OrderMethod> getAllOrderMethods() {
		log.info("getAllOrdermethod ");
		return ht.loadAll(OrderMethod.class);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderMethod> getOrderMethodByMode(String mode) {
		/*String hql=" from " +OrderMethod.class.getName()+" where mode=?";
		List<OrderMethod> oms=(List<OrderMethod>) ht.find(hql,mode);
		return oms;*/
		List<OrderMethod> om=(List<OrderMethod>) ht.findByCriteria(DetachedCriteria.forClass(OrderMethod.class).add(Restrictions.eq("mode",mode)));
		return om;
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean isOrderCodeExist(String code) {
		List<Long> rowsCount=(List<Long>) ht.findByCriteria(
		DetachedCriteria.forClass(OrderMethod.class).setProjection(Projections.rowCount()).add(Restrictions.eq("code", code)));
		return rowsCount.get(0)!=0?true:false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean isOrderMethodConnectedWithItemSale(Integer id) {
		List<Long> rowsCount=(List<Long>) ht.findByCriteria(
		DetachedCriteria.forClass(Item.class).setProjection(Projections.rowCount()).add(Restrictions.eq("omSale.id", id)));
		return rowsCount.get(0)!=0?true:false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean isOrderMethodConnectedWithItemPurchase(Integer id1) {
		List<Long> rowsCount=(List<Long>) ht.findByCriteria(
				DetachedCriteria.forClass(Item.class).setProjection(Projections.rowCount()).add(Restrictions.eq("omPurchase.id", id1)));
				return rowsCount.get(0)!=0?true:false;
	}
	
}

