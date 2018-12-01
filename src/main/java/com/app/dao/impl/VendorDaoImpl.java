package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;

@Repository
public class VendorDaoImpl implements IVendorDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveVendor(Vendor vd) {

		return (Integer) ht.save(vd);
	}

	@Override
	public void updateVendor(Vendor vd) {
		ht.update(vd);

	}

	@Override
	public void deleteVendor(Integer venId) {
		Vendor vd = new Vendor();
		vd.setVenId(venId);
		ht.delete(vd);

	}

	@Override
	public Vendor getOneVendorById(Integer venId) {
		return ht.get(Vendor.class, venId);
	}

	@Override
	public List<Vendor> getAllVendors() {
		return ht.loadAll(Vendor.class);
	}

}
