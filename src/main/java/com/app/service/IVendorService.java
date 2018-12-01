package com.app.service;

import java.util.List;

import com.app.model.Vendor;

public interface IVendorService {
	public Integer saveVendor(Vendor vd);

	public void updateVendor(Vendor vd);

	public void deleteVendor(Integer venId);

	public Vendor getOneVendorById(Integer venId);

	public List<Vendor> getAllVendors();

}
